package dk.usedmarket.repository;

import dk.usedmarket.domain.*;
import dk.usedmarket.repository.entity.AdvertisementPO;
import dk.usedmarket.repository.entity.CategoryPO;
import dk.usedmarket.repository.entity.LocationPO;
import dk.usedmarket.repository.entity.UserPO;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class Mapper {

    public User map(UserPO userPo, LocationPO locationPO) {
        return new User(
                userPo.getId(),
                userPo.getfName(),
                userPo.getlName(),
                userPo.getcName(),
                userPo.getPhoneNo(),
                userPo.getPhoneCode(),
                userPo.getEmail(),
                userPo.getCreationDate(),
                map(locationPO),
                userPo.getType()
        );
    }

    public Location map(LocationPO locationPO) {
        return new Location(
                locationPO.getZip(),
                locationPO.getCity()
        );
    }

    public Category map(CategoryPO categoryPO) {
        return new Category(
                categoryPO.getId(),
                categoryPO.getDescription(),
                categoryPO.getCount());
    }

    public List<Category> mapCategories(List<CategoryPO> categoryPOs) {
        return categoryPOs.stream().map(this::map).collect(Collectors.toList());
    }

    public Advertisement map(AdvertisementPO advertisementPO){
        return new Advertisement(
                advertisementPO.getId(),
                advertisementPO.getType(),
                advertisementPO.getHeadline(),
                advertisementPO.getText(),
                advertisementPO.getPrice(),
                advertisementPO.getUserId(),
                advertisementPO.getCategory(),
                advertisementPO.getCreationDate()
        );
    }

    public List<Advertisement> mapAdvertisements(List<AdvertisementPO> advertisementPOs){
        return advertisementPOs.stream().map(this::map).collect(Collectors.toList());
    }

    public AdvertisementWithLocation mapWithLocation(AdvertisementPO advertisementPO, LocationPO locationPO) {
        return new AdvertisementWithLocation(
                advertisementPO.getId(),
                advertisementPO.getType(),
                advertisementPO.getHeadline(),
                advertisementPO.getText(),
                advertisementPO.getPrice(),
                advertisementPO.getUserId(),
                advertisementPO.getCategory(),
                advertisementPO.getCreationDate(),
                this.map(locationPO)
        );
    }
}
