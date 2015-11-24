package cn.boxfish.redis.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by LuoLiBing on 15/11/23.
 */
@Component
public class SimpleListRedis implements ListRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    @Cacheable(value = "allBaseSet")
    @Override
    public Set<Map<String, Object>> list() {
        final Set<String> localhost = new Jedis("localhost").zrange("allBaseSet~keys", 0, 10);
        System.out.println(localhost);
        final Set allBaseSet = redisTemplate.boundZSetOps("allBaseSet").range(0, 10);
        System.out.println(allBaseSet);
        return init();
    }

    @Caching(evict = {
            @CacheEvict(value="baseSet", allEntries=true),
            @CacheEvict(value="allBaseSet", allEntries=true)
    })
    /*@CacheEvict(value = {"baseSet", "allBaseSet"}, key = "#id", allEntries = true, beforeInvocation = false)*/
    @Override
    public Map<String, Object> add(Long id, Map<String, Object> beanMap) {

        return beanMap;
    }

    @CacheEvict(value = {"baseSet", "allBaseSet"}, key = "#id", allEntries = true, beforeInvocation = false)
    @Override
    public void delete(Long id) {

    }

    @Cacheable(value = "baseSet", key = "#id")
    @Override
    public Map<String, Object> get(Long id) {
        return null;
    }


    private Set<Map<String, Object>> init() {
        Set<Map<String, Object>> set = new HashSet<>();
        Map<String, Object> beanMap = new HashMap<>();
        beanMap.put("id", 1L);
        beanMap.put("name", "aaaaaaaaaa");
        set.add(beanMap);
        beanMap = new HashMap<>();
        beanMap.put("id", 2L);
        beanMap.put("name", "bbbbbbbbbb");
        set.add(beanMap);
        beanMap = new HashMap<>();
        beanMap.put("id", 3L);
        beanMap.put("name", "cccccccccc");
        set.add(beanMap);

        return set;
    }
}
