package dk.howard.repository;

import dk.howard.domain.Id;
import dk.howard.domain.Name;
import dk.howard.domain.User;
import dk.howard.repository.entity.UserTestPO;
import dk.howard.repository.entitymanager.DemoEntityManager;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Dependent
public class Repository {
    private final EntityManager entityManager;

    @Inject
    public Repository(DemoEntityManager entityManager) {
        this.entityManager = entityManager.getEntityManager();
    }

    public void createUser(Name name) {
        UserTestPO userTestPO = new UserTestPO(name.getName());
        entityManager.persist(userTestPO);
    }

    public User findUserById(Id id) {
        UserTestPO po = entityManager.find(UserTestPO.class, id.getId());
        return new User(new Id(po.getId()), new Name(po.getUserName()));
    }

    public User findUserByName(Name name) {
        UserTestPO userTestPO = findByName(name.getName());
        return new User(new Id(userTestPO.getId()), new Name(userTestPO.getUserName()));
    }

    private UserTestPO findByName(String name) {
        try {
            return entityManager.createNamedQuery(UserTestPO.FIND_BY_NAME, UserTestPO.class)
                    .setParameter(UserTestPO.NAME_PARAMETER, name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
