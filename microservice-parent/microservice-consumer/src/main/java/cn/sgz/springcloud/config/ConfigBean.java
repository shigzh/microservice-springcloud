package cn.sgz.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 客户端负载均衡 与 服务端负载均衡的区别在于：客户端负载均衡要维护一份服务列表。
 * 客户端负载均衡和服务端负载均衡最大的区别在于服务清单所存储的位置。在客户端负载均衡中，每个客户端服务
 * 都有一份自己要访问的服务端清单，这些清单统统都是从Eureka服务注册中心获取的。而在服务端负载均衡中，只
 * 要负载均衡器维护一份服务端列表;
 *
 * Ribbon 属于一套客户端负载均衡器
 *
 * @Description:
 * @Auther:shigzh
 * @create 2019/5/8 10:00
 */
@Configuration
public class ConfigBean {
    // 向容器中添加 RestTemplate 组件,直接通过此组件可调用 REST 接口(必须在这里配置一下，否则注入的时候不好使)
    // 适用于不使用接口的应用（Ribbon+RestTemplate）
    @LoadBalanced //@LoadBalanced表示这个RestTemplate开启负载均衡（默认是轮询）
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    /**
     * 默认情况下会采用轮询策略，如果希望采用其它策略，则指定IRule实现
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
        //return new BestAvailableRule();//选择一个最小的并发请求的server
        return new RoundRobinRule();//轮询
        //return new RandomRule();//随机
        //return new WeightedResponseTimeRule();//根据响应时间分配一个weight，响应时间越长，weight越小，被选中的可能性越低。
    }
}
