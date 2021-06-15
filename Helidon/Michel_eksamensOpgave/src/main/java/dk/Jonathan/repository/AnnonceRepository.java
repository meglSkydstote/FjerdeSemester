package dk.Jonathan.repository;

import dk.Jonathan.domain.Advertisement;
import dk.Jonathan.domain.Id;
import dk.Jonathan.domain.UserInfo;
import dk.Jonathan.repository.entity.AdvertisementPO;
import dk.Jonathan.repository.entity.CityPO;
import dk.Jonathan.repository.entity.UserPO;
import dk.Jonathan.repository.entitymanager.EntityManagerWrapper;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.Collection;


@Dependent
public class AnnonceRepository {

    private EntityManager entityManager;
    private Mapper mapper;

    @Inject
    public AnnonceRepository(EntityManagerWrapper entityManager, Mapper mapper) {
        this.entityManager = entityManager.getEntityManager();
        this.mapper = mapper;
    }

    public Collection<Advertisement> getAdvisertisements() {
        return mapper.map(entityManager.createNamedQuery(AdvertisementPO.FIND_ALL, AdvertisementPO.class).getResultList());
    }

    public Advertisement getAdvertisement(Id id) {
        return null;
    }


    public void createUser(UserInfo userInfo, String zipcode) {

        CityPO cityPO = entityManager.find(CityPO.class, zipcode);

        UserPO qpo = new UserPO(
                userInfo, cityPO
        );
        cityPO.addUser(qpo);


        entityManager.persist(qpo);


    }
}