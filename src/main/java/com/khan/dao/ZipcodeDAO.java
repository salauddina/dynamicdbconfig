package com.khan.dao;

import com.khan.interfaces.IdentityDB;
import com.khan.entity.ZipCode;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class ZipcodeDAO extends BaseEntityDao<ZipCode>{

    @Inject
    public ZipcodeDAO(@IdentityDB EntityManager entityManager) {
        super(entityManager);
    }
}
