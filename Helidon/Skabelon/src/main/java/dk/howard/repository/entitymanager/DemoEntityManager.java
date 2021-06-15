package dk.howard.repository.entitymanager;

import javax.persistence.EntityManager;

public class DemoEntityManager {

    private final EntityManager entityManager;

    public DemoEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
