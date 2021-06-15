package dk.howard.repository.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "MINI_USER")
@NamedQueries({
        @NamedQuery(name = "UserPO.findAll", query = "SELECT u FROM UserPO u")})
public class UserPO {
    public static final String FIND_ALL = "UserPO.findAll";

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID", columnDefinition = "VARCHAR(40)", nullable = false, updatable = false, unique = true)
    private String id;

    @Column(name = "USER_NAME", columnDefinition = "VARCHAR(40)", nullable = false, unique = true)
    private String userName;

    @Column(name = "PASS_WORD", columnDefinition = "VARCHAR(40)", nullable = false)
    private String password;

    @Column(name = "EMAIL", columnDefinition = "VARCHAR(40)", nullable = false, unique = true)
    private String email;

    @Version
    @Column(name = "CREATED", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime created;

    public UserPO() {
        // JPA
    }

    public UserPO(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}
