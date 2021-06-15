package dk.Jonathan.repository.entitymanager;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RequestScoped
public class EntityManagerProducer {

    private static final String PERSISTENCE_UNIT = "marketPU";

    @PersistenceContext(unitName = PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Produces
    @RequestScoped
    public EntityManagerWrapper produce() {
        return new EntityManagerWrapper(entityManager);
    }

}
