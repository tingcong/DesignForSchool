package com.dg.redisTemplate;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by zy on 2017/1/12.
 */
//@Service("userForRedisService")
@Service
public class UserForRedisService {
    RedisTemplate<String, UserForRedis> redisTemplate;

    public RedisTemplate<String, UserForRedis> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, UserForRedis> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void put(UserForRedis user) {
        redisTemplate.opsForHash().put(user.getObjectKey(), user.getKey(), user);
    }

    public void delete(UserForRedis key) {
        redisTemplate.opsForHash().delete(key.getObjectKey(), key.getKey());
    }

    public UserForRedis get(UserForRedis key) {
        return (UserForRedis) redisTemplate.opsForHash().get(key.getObjectKey(), key.getKey());
    }
}
