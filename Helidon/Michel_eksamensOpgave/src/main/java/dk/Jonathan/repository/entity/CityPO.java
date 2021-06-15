package dk.Jonathan.repository.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Table (name = "CITY")
public class CityPO {


    @Id
    @Column(name = "ZIP_CODE", columnDefinition = "CHAR(4)", nullable = false, unique = true)
    private String zipcode;

    @Column(name = "CITY", columnDefinition = "VARCHAR(40)", nullable = false)
    private String city;

    @OneToMany(mappedBy = "cityPO", cascade = CascadeType.ALL)
    private List<UserPO> users = new ArrayList<>();

    public CityPO() {
    }

    public CityPO(String zipcode, String firstName) {
        this.zipcode = zipcode;
        this.city = firstName;

    }
    public void addUser (UserPO userPO){users.add(userPO);}

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public List<UserPO> getUsers() {
        return users;
    }
}

