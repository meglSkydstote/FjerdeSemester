package dk.usedmarket.repository.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@NamedQueries({
        @NamedQuery(name = "LocationPO.findById", query = "SELECT u FROM LocationPO u WHERE u.zip = :zip"),
})
@Entity
@Table(name = "CITY")
public class LocationPO {
    public static final String ID_PARAMETER = "zip";
    public static final String FIND_BY_ID = "LocationPO.findById";

    @Id
    @Column(name = "ZIP_CODE", columnDefinition = "varchar(255)", unique = true)
    private String zip;

    @Column(name = "CITY", columnDefinition = "VARCHAR(40)", nullable = false)
    private String city;

    public LocationPO() {
        //JPA
    }

    public LocationPO(String zip, String city) {
        this.zip = zip;
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }
}

