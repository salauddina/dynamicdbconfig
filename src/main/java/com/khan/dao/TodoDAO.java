package com.khan.dao;

import com.khan.interfaces.IdentityDB;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class TodoDAO  extends BaseEntityDao {

    public TodoDAO() { }

    @Inject
    public TodoDAO(@IdentityDB  EntityManager entityManager) {
        super(entityManager);
    }
//    private EntityManager em;
//
//
//    @Inject
//    public TodoDAO(@IdentityDB EntityManager entityManager) {
//        this.em = entityManager;
//    }
//
//    public List getAll() {
//        return em.createNamedQuery("Todo.findAll", Todo.class).getResultList();
//    }
//
//    public Todo findById(Long id) {
//        return em.find(Todo.class, id);
//    }
//
//    public void update(Todo todo) {
//        em.merge(todo);
//    }
//
//    public void create(Todo todo) {
//        em.persist(todo);
//    }
//
//    public void delete(Todo todo) {
//        if (!em.contains(todo)) {
//            todo = em.merge(todo);
//        }
//
//        em.remove(todo);
//    }
}
