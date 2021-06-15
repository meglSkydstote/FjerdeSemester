package dk.howard.repository.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ADDRESS")
public class AddressPO {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "STREET", columnDefinition = "VARCHAR(40)", nullable = false)
    private String street;

    @Column(name = "CITY", columnDefinition = "VARCHAR(40)", nullable = false)
    private String city;

    @OneToOne(mappedBy = "address")
    private UserTestPO user;

    public AddressPO() {
        //JPA
    }

    public AddressPO(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public UUID getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    //public UserTestPO getUser() {
    //    return user;
    //}

    //public void setUser(UserTestPO user) {
    //   this.user = user;
    //}
}
