package com.qlzy.common.util;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by Administrator on 2018/4/10.
 */
public class RedisCheck {
    /***
     * 是否存在key true存在 false 不存在
     * @param redisTemplate
     * @param key
     * @param value
     * @return
     */
    public static boolean checkHashKey(RedisTemplate redisTemplate,String key,String value){
        if(null != redisTemplate.opsForHash().hasKey(key,value) && redisTemplate.opsForHash().hasKey(key,value)){
           return true;
        }else{
            return false;
        }
    }
}
