package com.huaweisoft.dao;

import java.util.List;

/**
 * 基类接口
 */
public interface BaseDao<T> {
    
    T getOne(int id);

    List<T> getAll();

    void insert(T object);

    int update(T object);

    int deleteById(Object id);
}
