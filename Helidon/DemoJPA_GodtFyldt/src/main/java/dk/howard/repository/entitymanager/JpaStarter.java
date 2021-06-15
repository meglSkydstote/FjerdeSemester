package dk.howard.repository.entitymanager;

import org.jboss.weld.environment.se.events.ContainerInitialized;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class JpaStarter {

    @PersistenceUnit(unitName = "demo")
    private EntityManagerFactory entityManagerFactory;

    public void onInitialized(@Observes ContainerInitialized event) {
        entityManagerFactory.createEntityManager().getMetamodel();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

}
