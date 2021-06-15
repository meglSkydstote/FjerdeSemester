package dk.Jonathan.service;

import dk.Jonathan.domain.Advertisement;
import dk.Jonathan.domain.UserInfo;
import dk.Jonathan.repository.AnnonceRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collection;

@Transactional(rollbackOn = Exception.class)
@Dependent
public class AnnonceService implements Service {

    private AnnonceRepository repository;

    @Inject
    public AnnonceService(AnnonceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Advertisement> getAdvertisements() {
        return repository.getAdvisertisements();
    }

    @Override
    public void createUser(UserInfo userInfo, String zipcode) {
        repository.createUser(userInfo, zipcode);
    }
}
