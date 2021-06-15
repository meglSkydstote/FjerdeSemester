package dk.Jonathan.repository.entitymanager;

import javax.persistence.EntityManager;

public class EntityManagerWrapper {

    private final EntityManager entityManager;

    public EntityManagerWrapper(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
