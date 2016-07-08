package com.netease.ysf.redis;

import redis.clients.jedis.ShardedJedis;

/**
 * Created by 谭化友 on 2016/7/7
 */
public interface RedisDataSource {
    ShardedJedis getRedisClient();
    void returnResource(ShardedJedis shardedJedis);
}
