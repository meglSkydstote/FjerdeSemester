package dk.Jonathan.repository.entity;

import dk.Jonathan.domain.UserInfo;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AD_USER")
public class UserPO {

    @Id
    @GeneratedValue()
    @Column(name = "ID", columnDefinition = "VARCHAR(40)", nullable = false, updatable = false, unique = true)
    @Type(type = "uuid-char")
    private String id;

    @Column(name = "FIRST_NAME", columnDefinition = "VARCHAR(30)", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", columnDefinition = "VARCHAR(30)", nullable = false)
    private String lastName;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private int phone_Number;

    @Column(name = "EMAIL", columnDefinition = "VARCHAR(100)", nullable = false)
    private String email;

    @Column(name = "CREATION_DATE", columnDefinition = "DATE", nullable = false)
    private LocalDate creationDate;

    @Column(name = "TYPE", columnDefinition = "VARCHAR (10)", nullable = false)
    private String type;

    @Column(name = "COMPANY_NAME", columnDefinition = "VARCHAR(40)", nullable = false)
    private String companyName;

    @Column(name = "PHONE_CODE", columnDefinition = "VARCHAR(10)", nullable = false)
    private String phone_code;

    @ManyToOne
    @JoinColumn(name = "CITY_FK")
    private CityPO cityPO;

    @OneToMany(mappedBy = "userPO", cascade = CascadeType.ALL)
    private List<AdvertisementPO> advertisement = new ArrayList<>();


    public UserPO(UserInfo userinfo, CityPO cityPO) {
        this.firstName = userinfo.getName().getFirstName();
        this.lastName = userinfo.getName().getLastName();
        this.phone_Number = userinfo.getPhone_number();
        this.email = userinfo.getEmail();
        this.creationDate = LocalDate.now();
        this.type = userinfo.getType();
        this.companyName = userinfo.getCompanyName();
        this.phone_code = userinfo.getPhone_code();
        this.cityPO = cityPO;

    }

    public UserPO() {
        //JPA
    }

    public void addAdvertisement(AdvertisementPO advertisementPO) {
        advertisement.add(advertisementPO);
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhone_Number() {
        return phone_Number;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getType() {
        return type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPhone_code() {
        return phone_code;
    }

    public CityPO getCityPO() {
        return cityPO;
    }

    public List<AdvertisementPO> getAdvertisement() {
        return advertisement;
    }
}
