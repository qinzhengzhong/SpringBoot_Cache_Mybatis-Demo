package com.allan.base.mapper;

/**
 * 基础service实现类
 */
public abstract class BaseServiceImpl implements BaseService{

    public abstract BaseMapper getMapper();
    @Override
    public <T> int deleteByPrimaryKey(Object id) {
        return getMapper().deleteByPrimaryKey(id);
    }
    @Override
    public <T> int insert(T t) {
        return getMapper().insert(t);
    }

    @Override
    public <T> int insertSelective(T t) {
        return getMapper().insertSelective(t);
    }

    @Override
    public <T> T selectByPrimaryKey(Object id) {
        return getMapper().selectByPrimaryKey(id);
    }

    @Override
    public <T> int updateByPrimaryKey(T t) {
        return getMapper().updateByPrimaryKey(t);
    }

    @Override
    public <T> int updateByPrimaryKeySelective(T t) {
        return getMapper().updateByPrimaryKeySelective(t);
    }
}
