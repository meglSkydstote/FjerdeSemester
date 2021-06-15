package dk.Jonathan.domain;

import java.time.LocalDate;

public class User {
    private final Id id;
    private UserInfo userInformation;
    private final LocalDate creationDate;
    private City city;

    public User(Id id, UserInfo userInformation, LocalDate creationDate, City city) {
        this.id = id;
        this.userInformation = userInformation;
        this.creationDate = creationDate;
        this.city = city;
    }

    public Id getId() {
        return id;
    }

    public UserInfo getUserInformation() {
        return userInformation;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }


    public City getCity(){
        return city;
    }
}

