package com.netease.ysf.redis.impl;

import com.netease.ysf.redis.RedisDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by 谭化友 on 2016/7/7
 */

@Repository("redisDataSource")
public class RedisDataSourceImpl implements RedisDataSource {

    @Autowired
    private ShardedJedisPool shardedJedisPool;

    public ShardedJedis getRedisClient() {
        try {
            return shardedJedisPool.getResource();
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public void returnResource(ShardedJedis shardedJedis) {
        shardedJedisPool.returnResource(shardedJedis);
    }
}
