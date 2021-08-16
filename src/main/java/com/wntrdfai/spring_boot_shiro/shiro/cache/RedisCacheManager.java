package com.wntrdfai.spring_boot_shiro.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * @author wntrdfai
 * @Packagecom.wntrdfai.spring_boot_shiro.shiro.cache
 * @date 2021/8/16 9:33
 * 作用: 自定义shiro缓存管理器
 */
public class   RedisCacheManager implements CacheManager {
    /**
     *
     * @param cacheName 认证或者是授权缓存的统一名称
     * @param <K>
     * @param <V>
     * @return
     * @throws CacheException
     */
    @Override
    public <K, V> Cache<K, V> getCache(String cacheName) throws CacheException {
        System.out.println(cacheName);
        return new RedisCache(cacheName);
    }
}
