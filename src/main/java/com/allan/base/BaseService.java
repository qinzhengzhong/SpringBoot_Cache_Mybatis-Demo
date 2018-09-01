package com.allan.base;

/**
 * 基础service
 */
public interface BaseService {
    public abstract BaseMapper getMapper();

    public <T> int insert(T t);

    public <T> int insertSelective(T t);

    public <T> int deleteByPrimaryKey(Object id);

    public <T> int updateByPrimaryKeySelective(T t);

    public <T> int updateByPrimaryKey(T t);

    public <T> T selectByPrimaryKey(Object id);
}
