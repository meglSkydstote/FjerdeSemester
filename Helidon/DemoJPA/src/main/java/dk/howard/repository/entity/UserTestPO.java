package dk.howard.repository.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@NamedQueries({
        @NamedQuery(name = "UserTestPO.findByName", query = "SELECT u FROM UserTestPO u where u.userName=:name"),
        @NamedQuery(name = "UserTestPO.findAll", query = "SELECT u FROM UserTestPO u"),
        @NamedQuery(name = "UserTestPO.findAllJ", query = "FROM UserTestPO u JOIN FETCH u.address a")
})
@Entity
@Table(name = "DB_USER")
public class UserTestPO {
    public static final String FIND_BY_NAME = "UserTestPO.findByName";
    public static final String FIND_ALL = "UserTestPO.findAll";
    public static final String FIND_ALL_J = "UserTestPO.findAllJ";
    public static final String NAME_PARAMETER = "name";

    @Id
    @GeneratedValue
    @Column(name = "ID")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "NAME", columnDefinition = "VARCHAR(40)", nullable = false)
    private String userName;

    @Column(name = "EMAIL", columnDefinition = "VARCHAR(40)", nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_fk", referencedColumnName = "id")
    private AddressPO address;

    public UserTestPO() {
        //JPA
    }

    public UserTestPO(String userName, String email, AddressPO address) {
        this.userName = userName;
        this.email = email;
        this.address = address;
        //address.setUser(this);
    }

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public AddressPO getAddress() {
        return address;
    }

    public void setAddress(AddressPO address) {
        this.address = address;
    }
}
