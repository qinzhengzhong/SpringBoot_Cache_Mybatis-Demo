package com.allan.base.mapper;

/**
 * 基础dao工具类
 */
public interface BaseMapper {

    public <T> int insert(T t);

    public <T> int insertSelective(T t);

    public <T> int deleteByPrimaryKey(Object id);

    public <T> int updateByPrimaryKeySelective(T t);

    public <T> int updateByPrimaryKey(T t);

    public <T> T selectByPrimaryKey(Object id);
}
