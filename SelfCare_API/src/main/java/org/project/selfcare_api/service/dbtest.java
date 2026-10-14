package org.project.selfcare_api.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
@Service
public class dbtest {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public String testConnection() {
        Object result = entityManager
                .createNativeQuery("SELECT version()")
                .getSingleResult();

        return result.toString();
    }
}
