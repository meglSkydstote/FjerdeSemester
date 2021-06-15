package dk.usedmarket.repository.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@NamedQueries({
        @NamedQuery(name = "AdvertisementPO.findAllByCategory", query = "SELECT u FROM AdvertisementPO u WHERE u.category = :categoryId"),
        @NamedQuery(name = "AdvertisementPO.findById", query = "SELECT u FROM AdvertisementPO u WHERE u.id = :id"),
        @NamedQuery(name = "AdvertisementPO.findByUserId", query = "SELECT u FROM AdvertisementPO u WHERE u.userId = :id")
})
@Entity
@Table(name = "ADVERTISEMENT")
public class AdvertisementPO {

    public static final String FIND_BY_CATEGORY = "AdvertisementPO.findAllByCategory";
    public static final String CATEGORY_PARAMETER = "categoryId";
    public static final String FIND_BY_ID = "AdvertisementPO.findById";
    public static final String FIND_BY_USER_ID = "AdvertisementPO.findByUserId";
//    {
//        "type": "SALE",
//        "headline": "BUY CHEAP LIVE LONG",
//        "text": "Here you can buy this, that, and nothing",
//        "price": 50,
//        "category": 3,
//        "creationDate": "01-01-2021"
//    }

    @Id
    @GeneratedValue
    @Column(name = "ID", columnDefinition = "VARCHAR(255)", nullable = false, updatable = false, unique = true)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "TYPE", columnDefinition = "VARCHAR(255)", nullable = false)
    private String type;

    @Column(name = "HEADLINE", columnDefinition = "VARCHAR(255)", nullable = false)
    private String headline;

    @Column(name = "TEXT", columnDefinition = "VARCHAR(1000)", nullable = true)
    private String text;

    @Column(name = "PRICE", columnDefinition = "int", nullable = false)
    private int price;

    @Column(name = "USER_FK", columnDefinition = "VARCHAR(255)", nullable = false)
    @Type(type = "uuid-char")
    private UUID userId;

    @Column(name = "CATEGORY_FK", columnDefinition = "int", nullable = false)
    private int category;

    @Column(name = "CREATION_DATE", columnDefinition = "date", nullable = false)
    private String creationDate;

    public AdvertisementPO() {
        // JPA
    }

    public AdvertisementPO(String type,
                           String headline,
                           String text,
                           int price,
                           UUID userId,
                           int category,
                           String creationDate
    ) {
        this.type = type;
        this.headline = headline;
        this.text = text;
        this.price = price;
        this.userId = userId;
        this.category = category;
        this.creationDate = creationDate;
    }

    public UUID getId() {
        return id;
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

    public UUID getUserId() {
        return userId;
    }

    public int getCategory() {
        return category;
    }

    public String getCreationDate() {
        return creationDate;
    }
}
