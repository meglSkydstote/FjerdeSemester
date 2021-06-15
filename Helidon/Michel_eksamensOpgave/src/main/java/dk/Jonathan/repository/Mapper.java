package dk.Jonathan.repository;

import dk.Jonathan.domain.*;
import dk.Jonathan.repository.entity.AdvertisementPO;
import dk.Jonathan.repository.entity.CityPO;
import dk.Jonathan.repository.entity.UserPO;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Dependent
public class Mapper {

    public Id map(UUID id) {
        return new Id(id.toString());
    }


    public CityPO map(City city){
        return new CityPO(
                city.getZipCode(),
                city.getCity());
    }


    public City map(CityPO cityPO){
        return new City(
                cityPO.getZipcode(),
                cityPO.getCity(),
                cityPO.getUsers().stream().map(this::map).collect(Collectors.toList()));
    }


    public List<Advertisement> map(List<AdvertisementPO> advertisementPO) {
        return advertisementPO.stream().map(this::map).collect(Collectors.toList());
    }

    public Advertisement map(AdvertisementPO advertisementPO) {
        Advertisement a = new Advertisement(map(advertisementPO.getId()),
                advertisementPO.getCategory(),
                advertisementPO.getType(),
                advertisementPO.getText(),
                advertisementPO.getHeadline(),
                advertisementPO.getPrice(),
                advertisementPO.getCreationDate());


        return a;
    }

    public Name map (String firstname, String lastName) {return new Name(firstname, lastName);}


    public User map(UserPO userPO){

        User u = new User(new Id(userPO.getId()),
                new UserInfo(
                        new Name(userPO.getFirstName(), userPO.getLastName()),
                        userPO.getPhone_Number(),
                        userPO.getPhone_code(),
                        userPO.getEmail(),
                        userPO.getType(),
                        userPO.getCompanyName()),
                userPO.getCreationDate(),
                map(userPO.getCityPO()));


    return u;
    }
}
