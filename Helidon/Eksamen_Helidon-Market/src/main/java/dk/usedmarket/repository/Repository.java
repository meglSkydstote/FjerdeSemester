package dk.usedmarket.repository;

import dk.usedmarket.domain.Advertisement;
import dk.usedmarket.domain.AdvertisementWithLocation;
import dk.usedmarket.domain.Category;
import dk.usedmarket.domain.User;
import dk.usedmarket.repository.entity.AdvertisementPO;
import dk.usedmarket.repository.entity.CategoryPO;
import dk.usedmarket.repository.entity.LocationPO;
import dk.usedmarket.repository.entity.UserPO;
import dk.usedmarket.repository.entitymanager.MsSqlEntityManager;
import dk.usedmarket.resource.dto.CategoryDTO;
import dk.usedmarket.service.request.CreateAdvertisementRequest;
import dk.usedmarket.service.request.CreateUserRequest;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


@Dependent
@Transactional(value = Transactional.TxType.MANDATORY)
public class Repository {
    private final EntityManager entityManager;
    private Mapper mapper;

    @Inject
    public Repository(MsSqlEntityManager entityManager) {
        this.entityManager = entityManager.getEntityManager();
        mapper = new Mapper();
    }

    ///////////////////
    /// User

    public void createUser(CreateUserRequest request) {
        UserPO userPO = new UserPO(
                request.getfName(),
                request.getlName(),
                request.getcName(),
                request.getPhoneNo(),
                request.getPhoneCode(),
                request.getEmail(),
                request.getCreationDate(),
                request.getZip(),
                request.getType()
        );
        entityManager.persist(userPO);
    }

    public User findUserById(UUID id) {
        try {
            UserPO userPO = entityManager.createNamedQuery(UserPO.FIND_BY_ID, UserPO.class)
                    .setParameter(UserPO.USER_ID, id)
                    .getSingleResult();

            return mapper.map(userPO, entityManager.createNamedQuery(LocationPO.FIND_BY_ID, LocationPO.class)
                    .setParameter(LocationPO.ID_PARAMETER, userPO.getZip())
                    .getSingleResult());
        } catch (NoResultException e) {
            return null;
        }
    }

    ///////////////////
    /// Category

    public List<Category> getCategories() {
        return mapper.mapCategories(entityManager.createNamedQuery(CategoryPO.FIND_ALL, CategoryPO.class).getResultList());
    }

    ///////////////////
    /// Advertisement

    public void createAdvertisement(CreateAdvertisementRequest request) {
        AdvertisementPO advertisementPO = new AdvertisementPO(
                request.getType(),
                request.getHeadline(),
                request.getText(),
                request.getPrice(),
                request.getUserId(),
                request.getCategory(),
                request.getCreationDate()
        );
        entityManager.persist(advertisementPO);
    }

    public List<Advertisement> findAdvertisementsByCategoryId(int categoryId) {
        List<AdvertisementPO> advertisementPOs = findByCategoryId(categoryId);
        return mapper.mapAdvertisements(advertisementPOs);
    }

    private List<AdvertisementPO> findByCategoryId(int categoryId) {
        try {
            return entityManager.createNamedQuery(AdvertisementPO.FIND_BY_CATEGORY, AdvertisementPO.class)
                    .setParameter(AdvertisementPO.CATEGORY_PARAMETER, categoryId)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Advertisement findById(UUID id) {
        return mapper.map(entityManager.createNamedQuery(AdvertisementPO.FIND_BY_ID, AdvertisementPO.class)
                .setParameter("id", id)
                .getSingleResult()
        );
    }

    public List<Advertisement> findAdvertisementsByUserId(UUID id) {
        return mapper.mapAdvertisements(entityManager.createNamedQuery(AdvertisementPO.FIND_BY_USER_ID, AdvertisementPO.class)
                .setParameter("id", id)
                .getResultList()
        );
    }

    public List<AdvertisementWithLocation> findByCategoryWithLocationId(int categoryId) {
        List<AdvertisementWithLocation> adWithLocation = Collections.emptyList();
        try {
            List<AdvertisementPO> adPOS = entityManager.createNamedQuery(AdvertisementPO.FIND_BY_CATEGORY, AdvertisementPO.class)
                    .setParameter(AdvertisementPO.CATEGORY_PARAMETER, categoryId)
                    .getResultList();
            for (AdvertisementPO adPO : adPOS) {
                UserPO userPO = entityManager.createNamedQuery(UserPO.FIND_BY_ID, UserPO.class)
                        .setParameter(UserPO.USER_ID, adPO.getUserId())
                        .getSingleResult();
                LocationPO locationPO = entityManager.createNamedQuery(LocationPO.FIND_BY_ID, LocationPO.class)
                        .setParameter(LocationPO.ID_PARAMETER, userPO.getZip())
                        .getSingleResult();
                adWithLocation.add(mapper.mapWithLocation(adPO, locationPO));
            };
            return adWithLocation;
        } catch (NoResultException e) {
            return null;
        }
    }

}

