package com.netease.ysf.redis.utils;

import com.netease.ysf.redis.RedisDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.ShardedJedis;

/**
 * Created by 谭化友 on 2016/7/7
 */

@Repository("redisUtils")
public class RedisUtils {

    @Autowired
    private RedisDataSource redisDataSource;

    public String set(String key, String value) {
        String result = null;

        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.set(key, value);
        } catch (Exception e) {
            // ignore
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    public String get(String key) {
        String result = null;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }

        try {
            result = shardedJedis.get(key);

        } catch (Exception e) {
            // ignore
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }
}