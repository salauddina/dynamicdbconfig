package com.khan.producers;

import com.khan.interfaces.IdentityDB;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class EntityManagerProducer {

    @Produces
    @IdentityDB
    public EntityManager produceEntityManager() {

        Map<String, String> properties = new HashMap<>();
        //Hibernet + hikaracp oracle example
//        properties.put("javax.persistence.schema-generation.database.action", "drop-and-create");
        properties.put("javax.persistence.provider", "org.hibernate.jpa.HibernatePersistenceProvider");
        properties.put("javax.persistence.jdbc.driver.class", "oracle.jdbc.driver.OracleDriver");
        properties.put("javax.persistence.jdbc.url", "");
        properties.put("javax.persistence.jdbc.user", "");
        properties.put("javax.persistence.jdbc.password", "");


        properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
        properties.put("hibernate.hikari.minimumIdle", "5");
        properties.put("hibernate.hikari.maximumPoolSize", "10");
        properties.put("hibernate.hikari.idleTimeout", "30000");
        properties.put("hibernate.connection.provider_class", "org.hibernate.hikaricp.internal.HikariCPConnectionProvider");


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("identityUnit", properties);
        return emf.createEntityManager();
    }

    public void close(@Disposes  @IdentityDB EntityManager em) {
        em.close();
    }
}
