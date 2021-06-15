package dk.Jonathan.repository.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name = "ADVERTISEMENT")
@NamedQueries({
        @NamedQuery(name = "AdvertisementPO.findAll", query = "SELECT u FROM AdvertisementPO u")})
public class AdvertisementPO {
    public static final String FIND_ALL = "AdvertisementPO.findAll";


    @Id
    @GeneratedValue()
    @Column(name = "ID", columnDefinition = "VARCHAR(40)", nullable = false, updatable = false, unique = true)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "CATEGORY", columnDefinition = "VARCHAR(40)", nullable = false)
    private String category;

    @Column(name = "TYPE", columnDefinition = "VARCHAR(40)", nullable = false)
    private String type;

    @Column(name = "HEADLINE", columnDefinition = "VARCHAR(40)", nullable = false)
    private String headline;

    @Column(name = "TEXT", columnDefinition = "VARCHAR(40)", nullable = false)
    private String text;

    @Column(name = "PRICE", nullable = false)
    private int price;

    @Column(name = "CREATION_DATE", columnDefinition = "DATE", nullable = false)
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "USER_FK")
    private UserPO userPO;

    public AdvertisementPO(String category, String type, String headline, String text, int price, Date creationDate, UserPO userPO) {
        this.category = category;
        this.type = type;
        this.headline = headline;
        this.text = text;
        this.price = price;
        this.creationDate = creationDate;
        this.userPO = userPO;
    }

    public AdvertisementPO() {
    }

    public UUID getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getHeadline() {
        return headline;
    }

    public String getText() {
        return text;
    }

    public int getPrice() {
        return price;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public UserPO getUserPO() {
        return userPO;
    }
}
