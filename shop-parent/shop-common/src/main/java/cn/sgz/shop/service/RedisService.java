package cn.sgz.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 存值的时候建议加上命名空间  这样结构比较清晰
 * 比如：
 *   set sgz:name zhangsan
 *   set sgz:age 18
 *
 * final修饰参数的作用
 *    修饰的参数的值在方法体内是不能被修改的，即不能被重新赋值。否则编译就通不过
 *    想用的话就用基本类型，还是很有作用的。引用类型，还是算了吧（final String[] ag   ag[0]="5";修改了不会报错）
 *
 * @Description: redis服务类
 * @Auther:shigzh
 * @create 2019/5/12 14:44
 */
@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 写入缓存
     * @param key 存入redis的key
     * @param value 存入redis的key对应的值
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 写入缓存设置时效时间
     * @param key 存入redis的key
     * @param value 存入redis的key对应的值
     * @param expireTime 存入redis对应的过期时间(单位：秒)
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 批量删除对应的value
     * @param keys 要删除的对应的key
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     * @param pattern 符合正则表达式类型
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }
    /**
     * 删除对应的value
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }
    /**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }
    /**
     * 读取缓存
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }
    /**
     * 哈希 添加
     * @param key
     * @param field
     * @param value
     */
    public void hSet(String key, Object field, Object value){
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key,field,value);
    }

    /**
     * 哈希获取数据
     * @param key
     * @param field
     * @return
     */
    public Object hGet(String key, Object field){
        HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
        return hash.get(key,field);
    }

    /**
     * 列表添加(放入list列表头部，也可以理解为从list列表左边放入)
     * @param key
     * @param value
     */
    public void lPush(String key,Object value){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(key,value);
    }

    /**
     * 列表获取（后面两个参数是列表的范围，从0开始）
     * @param key
     * @param startIndex 开始位置
     * @param endIndex 结束位置
     * @return
     */
    public List<Object> lRange(String key, long startIndex, long endIndex){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(key,startIndex,endIndex);
    }

    /**
     * 集合添加
     * @param key
     * @param value
     */
    public void sAdd(String key,Object value){
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add(key,value);
    }

    /**
     * 集合获取
     * @param key
     * @return
     */
    public Set<Object> sMembers(String key){
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }

    /**
     * 有序集合添加
     * @param key
     * @param value
     * @param score 得分
     */
    public void zAdd(String key,Object value,double score){
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.add(key,value,score);
    }

    /**
     * 有序集合获取（在一定得分范围之内的）
     * @param key
     * @param startScore
     * @param endScore
     * @return
     */
    public Set<Object> rangeByScore(String key,double startScore,double endScore){
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, startScore, endScore);
    }
}
