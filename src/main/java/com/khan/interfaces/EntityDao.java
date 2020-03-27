package com.khan.interfaces;

import java.util.List;

public interface EntityDao<T> {
    T find(Long id, Class<T> entityClass);

    T find(String id, Class<T> entityClass);

    List<T> findAll(Class<T> entityClass, String tableName);

    T update(T entity) throws Exception;

    void save(T entity);

    void delete(T t);
}