package dk.usedmarket.service;

import dk.usedmarket.domain.Advertisement;
import dk.usedmarket.domain.AdvertisementWithLocation;
import dk.usedmarket.domain.Category;
import dk.usedmarket.domain.User;
import dk.usedmarket.repository.Repository;
import dk.usedmarket.service.request.CreateAdvertisementRequest;
import dk.usedmarket.service.request.CreateUserRequest;

import javax.enterprise.context.Dependent;
import javax.transaction.Transactional;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Transactional(rollbackOn = Exception.class)
@Dependent
public class Service {
    private final Repository repository;

    @Inject
    public Service(Repository repository) {
        this.repository = repository;
    }

    public void createUser(CreateUserRequest request) {repository.createUser(request);}

    public List<Category> getCategories() { return repository.getCategories(); }

    public void createAdvertisement(CreateAdvertisementRequest request) { repository.createAdvertisement(request); }

    public List<Advertisement> getAdvertisementsByCategory(int id) {
        return repository.findAdvertisementsByCategoryId(id);
    }

    public Advertisement getAdvertisement(UUID id) {
        return repository.findById(id);
    }

    public User getUserById(UUID id) {
        return repository.findUserById(id);
    }

    public List<Advertisement> getAdvertisementsById(UUID id) {
        return repository.findAdvertisementsByUserId(id);
    }

    public List<AdvertisementWithLocation> getAdvertisementsByCategoryWithLocation(int id){
        return repository.findByCategoryWithLocationId(id);
    }
}

