package dk.howard.repository.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "JPA_USER")
@NamedQueries({
        @NamedQuery(name = "UserPO.findAll", query = "SELECT u FROM UserPO u")})
public class UserPO {
    public static final String FIND_ALL = "UserPO.findAll";

    @Id
    @GeneratedValue
    @Column(name = "ID", columnDefinition = "VARCHAR(40)", nullable = false, updatable = false, unique = true)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "USER_NAME", columnDefinition = "VARCHAR(40)", nullable = false, unique = true)
    private String userName;

    @Column(name = "PASS_WORD", columnDefinition = "VARCHAR(40)", nullable = false)
    private String password;

    @Column(name = "EMAIL", columnDefinition = "VARCHAR(40)", nullable = false, unique = true)
    private String email;

    @Column(name = "CREATED", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime created;

    @Version
    @Column(name = "LAST_UPDATED", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime lastUpdated;

    public UserPO() {
        // JPA
    }

    public UserPO(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.created = LocalDateTime.now();
    }
}
