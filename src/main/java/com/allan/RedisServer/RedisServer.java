package com.allan.RedisServer;

import java.util.List;

public interface RedisServer {
    boolean set(final String key, Object obj);

    String get(final String key);

    boolean expire(final String key, long expire);

    <T> boolean setList(String key, List<T> list);

    <T> List<T> getList(String key, Class<T> clz);

    long lpush(final String key, Object obj);

    long rpush(final String key, Object obj);

    String lpop(final String key);

}
