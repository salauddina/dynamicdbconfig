package com.khan.dao;

import com.khan.interfaces.EntityDao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BaseEntityDao<T> implements EntityDao<T> {

    private EntityManager entityManager;

    public BaseEntityDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public BaseEntityDao() {
    }

    @Override
    public T find(Long id, Class<T> entityClass) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public T find(String id, Class<T> entityClass) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<T> findAll(final Class<T> entityClass, final String tableName) {
        return entityManager.createQuery("SELECT t FROM " + tableName + " t", entityClass).getResultList();
    }

    @Override
    public T update(final T entity) throws Exception {
        return entityManager.merge(entity);
    }

    @Override
    public void save(final T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(T entity) {

        if (!entityManager.contains(entity)) {
            entity = entityManager.merge(entity);
        }

        entityManager.remove(entity);
    }
}