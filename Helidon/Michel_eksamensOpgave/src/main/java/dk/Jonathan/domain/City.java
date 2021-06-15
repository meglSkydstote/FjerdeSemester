package dk.Jonathan.domain;

import java.util.List;

public class City {
    private String zipCode;
    private String city;
    private List<User> users;

    public City(String zipCode, String city, List<User> users) {
        this.zipCode = zipCode;
        this.city = city;
        this.users = users;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public List<User> getUsers(){
        return users;
    }
}
