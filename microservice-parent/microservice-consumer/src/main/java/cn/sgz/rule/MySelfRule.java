package cn.sgz.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 这个自定义规则配置类不能放在@ComponentScan所扫描的当前包下以及子包下，即启动类@SpringBootApplication
 * 否则我们自定义的配置类就会被所有的Ribbon客户端所共享，也就是说达不到特殊化定制为某一个服务定制负载均衡策略的目的了
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/15 14:56
 */
@Component
public class MySelfRule {
    /**
     * 默认情况下会采用轮询策略，如果希望采用其它策略，则指定IRule实现
     *
     * 我们也可以自己定义一个规则类继承extends AbstractLoadBalancerRule，然后在下面使用即可
     *
     * 负载均衡有好几种实现策略，常见的有：
     * 1. 随机 (Random)
     * 2. 轮询 (RoundRobin)
     * 3. 一致性哈希 (ConsistentHash)
     * 4. 哈希 (Hash)
     * 5. 加权（Weighted）
     * @return
     */
    @Bean
    public IRule ribbonRule() {
        //return new BestAvailableRule();//选择一个最小的并发请求的server(会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务)
        //return new RoundRobinRule();//轮询
        return new RandomRule();//随机
        //return new AvailabilityFilteringRule();//会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，还有并发的连接数量超过阈值的服务，然后对剩余的服务列表按照轮询策略进行访问
        //return new RetryRule();//先按照RoundRobinRule（轮询）的策略获取服务，如果获取服务失败则在指定时间内会进行重试;则在失效时间deadline之前不断的进行重试（重试时获取服务的策略还是RoundRobinRule中定义的策略），获取可用的服务
        //return new WeightedResponseTimeRule();//根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大，被选中的概率越高；刚启动时如果统计信息不足，则使用轮询策略，等统计信息足够，会切换到WeightedResponseTimeRule
        //return new ZoneAvoidanceRule();//(Finchley.SR1版本中默认均衡策略,目前G版本采用的是轮询策略；复合判断server所在区域的性能和server的可用性来选择服务器
    }
}
