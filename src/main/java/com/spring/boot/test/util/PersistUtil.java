package com.spring.boot.test.util;

import javax.persistence.EntityManager;

public class PersistUtil {

    public static String getState(EntityManager em, Object obj) {

        boolean isPersistentState = em.contains(obj);
        if(isPersistentState) {
            return "Persistent State";
        }

        Object identifier = em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(obj);
        if(identifier == null) {
            return "Transient State";
        }

        return "Detached State";
    }
}
