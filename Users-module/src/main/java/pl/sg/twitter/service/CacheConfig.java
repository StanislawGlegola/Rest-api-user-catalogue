package pl.sg.twitter.service;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Arrays;

@EnableCaching
@Configuration
public class CacheConfig extends CachingConfigurerSupport {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        Cache usersListCache = new ConcurrentMapCache("usersList");
        Cache usersCache = new ConcurrentMapCache("users");
        cacheManager.setCaches(Arrays.asList(usersCache, usersListCache));
        return cacheManager;
    }

    @Bean("customKeyGenerator")
    public KeyGenerator usersKeyGenerator() {
        return new CacheKeyGenerator();
    }

    private static class CacheKeyGenerator implements KeyGenerator {

        public Object generate(Object target, Method method, Object... params) {
            return target.getClass().getSimpleName() + "_"
                    + method.getName() + "_"
                    + StringUtils.arrayToDelimitedString(params, "_");
        }
    }
}
