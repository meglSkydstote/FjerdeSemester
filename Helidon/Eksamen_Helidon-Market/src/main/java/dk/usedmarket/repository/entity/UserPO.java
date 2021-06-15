package dk.usedmarket.repository.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

// {
//         "firstName":"Test",
//         "lastName":"2",
//         "companyName":"testro",
//         "phoneNumber":"88 88 88 88",
//         "phoneCode":"+45",
//         "email":"test@example.io",
//         "zip":"8330",
//         "type":"private"
//         }

@NamedQueries({
        @NamedQuery(name = "UserPO.findById", query = "Select u FROM UserPO u WHERE u.id = :id"),
})
@Entity
@Table(name = "AD_USER")
public class UserPO {
    public static final String FIND_BY_ID = "UserPO.findById";
    public static final String USER_ID = "id";

    @Id
    @GeneratedValue
    @Column(name = "ID", columnDefinition = "VARCHAR(255)", nullable = false, updatable = false, unique = true)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "FIRST_NAME", columnDefinition = "VARCHAR(255)", nullable = false)
    private String fName;

    @Column(name = "LAST_NAME", columnDefinition = "VARCHAR(255)", nullable = false)
    private String lName;

    @Column(name = "COMPANY_NAME", columnDefinition = "VARCHAR(255)", nullable = true)
    private String cName;

    @Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR(255)", nullable = false)
    private String phoneNo;

    @Column(name = "PHONE_CODE", columnDefinition = "VARCHAR(255)", nullable = false)
    private String phoneCode;

    @Column(name = "EMAIL", columnDefinition = "VARCHAR(255)", nullable = false, unique = true)
    private String email;

    @Column(name = "CREATION_DATE", columnDefinition = "date", nullable = false)
    private String creationDate;

    @Column(name = "CITY_FK", columnDefinition = "CHAR(255)", nullable = false)
    private String zip;

    @Column(name = "TYPE", columnDefinition = "varchar(255)", nullable = false)
    private String type;

    public UserPO() {
        // JPA
    }

    public UserPO(String firstName, String lastName, String companyName, String phoneNo, String phoneCode, String email, String creationDate, String zip, String type) {
        this.fName = firstName;
        this.lName = lastName;
        this.cName = companyName;
        this.phoneNo = phoneNo;
        this.phoneCode = phoneCode;
        this.email = email;
        this.creationDate = creationDate;
        this.zip = zip;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getcName() {
        return cName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public String getEmail() {
        return email;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getZip() {
        return zip;
    }

    public String getType() {
        return type;
    }
}

