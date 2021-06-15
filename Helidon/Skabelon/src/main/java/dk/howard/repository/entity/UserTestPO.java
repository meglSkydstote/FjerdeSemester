package dk.howard.repository.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@NamedQueries({
        @NamedQuery(name = "UserTestPO.findByName", query = "SELECT u FROM UserTestPO u where u.userName=:name")
})
@Entity
@Table(name = "USER_ID_CHAR")
public class UserTestPO {
    public static final String FIND_BY_NAME = "UserTestPO.findByName";
    public static final String NAME_PARAMETER = "name";

    @Id
    @GeneratedValue
    @Column(name = "ID")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "NAME", columnDefinition = "VARCHAR(40)", nullable = false)
    private String userName;

    public UserTestPO() {
        //JPA
    }

    public UserTestPO(String userName) {
        this.userName = userName;
    }

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }
}
