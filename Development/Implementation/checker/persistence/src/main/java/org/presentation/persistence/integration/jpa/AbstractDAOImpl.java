package org.presentation.persistence.integration.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author radio.koza
 */
public abstract class AbstractDAOImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

}