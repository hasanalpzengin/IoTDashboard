/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasanalpzengin.iotdashboard.config;

import java.lang.reflect.Method;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 *
 * @author hasalp
 */
@Configuration
@EnableRedisRepositories
public class RedisConfiguration extends CachingConfigurerSupport{
    @Autowired
    CacheProperties cacheProperties;
    
    private final String KEY_SEPERATOR = "#";
   
    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator(){
            @Override
            public Object generate(Object o, Method method, Object... os) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getSimpleName());
                sb.append(KEY_SEPERATOR);
                sb.append(method.getName());
                sb.append(KEY_SEPERATOR);
                for(Object param : os){
                    sb.append(param.toString());
                    sb.append(KEY_SEPERATOR);
                }
                String str = sb.toString();
                return str.substring(0, str.length()-1);
            }
        };
    }
    
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
    
    @Bean
    public RedisCacheManager redisCacheManager(JedisConnectionFactory jcf){
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .disableCachingNullValues()
                .entryTtl(Duration.ofMinutes(30))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()));
        
        redisCacheConfiguration.usePrefix();
        return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(jcf)
                .cacheDefaults(redisCacheConfiguration).build();
        
    }
    
    
}
