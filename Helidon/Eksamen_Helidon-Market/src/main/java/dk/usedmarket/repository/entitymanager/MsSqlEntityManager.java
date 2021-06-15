package dk.usedmarket.repository.entitymanager;

import javax.persistence.EntityManager;

public class MsSqlEntityManager {

    private final EntityManager entityManager;

    public MsSqlEntityManager(EntityManager entityManager) { this.entityManager = entityManager; }

    public EntityManager getEntityManager() { return entityManager; }
}
