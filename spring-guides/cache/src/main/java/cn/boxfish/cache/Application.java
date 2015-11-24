package cn.boxfish.cache;

import cn.boxfish.cache.jpa.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by LuoLiBing on 15/9/30.
 */
@SpringBootApplication
@EnableCaching
public class Application {

    private final static Logger log = LoggerFactory.getLogger(Application.class);

    @Component
    static class Runner implements CommandLineRunner {

        @Autowired
        private BookRepository bookRepository;

        @Autowired
        private CacheManager cacheManager;

        @Override
        public void run(String... args) throws Exception {
            // 查看是否每次都到数据库查询
            log.info(".... Fetching books");

//            System.out.println(categoryRepository.getCategoryById("1"));
//            categoryRepository.getCategoryById("1");
            log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
            log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));

            bookRepository.update("isbn-1234", "isbn-1234测试");
            log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));

            bookRepository.clear("isbn-1234");
            log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
            log.info("isbn-1234 -->" + bookRepository.test("isbn-1234"));
            final Collection<String> cacheNames = cacheManager.getCacheNames();
            for(String cache: cacheNames) {
                System.out.println(cache);
            }
//            log.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
//            log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
//            log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));*/
        }
    }

    /**
     * 缓存管理器
     * @return
     */
    @Bean
    public CacheManager cacheManager() {
        // 普通的ConcurrentMapCache
        return new ConcurrentMapCacheManager("books", "categorys");
        // 默认会注入StringRedisTemplate，只能保存String，如果换成其他对象无法保存到内存当中
        //return new RedisCacheManager(redisTemplate());
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        //factory.setHostName("localhost");
        //factory.setPort(redisPort);
        factory.setUsePool(true);
        return factory;
    }

    /**
     * 能保存到内存当中的对象必须是实现了Serializable接口
     * @return
     */
    @Bean
    RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
