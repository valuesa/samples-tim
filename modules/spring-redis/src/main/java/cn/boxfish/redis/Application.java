package cn.boxfish.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * Created by LuoLiBing on 15/11/25.
 */
@ImportResource("classpath:/spring.xml")
@ComponentScan(value = {"cn.boxfish"})
public class Application {

    /**
     * 主从配置
     * spring.redis.sentinel.master
     * spring.redis.sentinel.nodes host:port list
     * @return
     */
    @Bean
    public RedisConnectionFactory jedisConnectionFactory() {
        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration().master("mymaster")
                .sentinel("127.0.0.1", 26379).sentinel("127.0.0.1", 26380);
        return new JedisConnectionFactory(sentinelConfig);
    }
}
