package dk.usedmarket.domain;

import java.util.Date;
import dk.usedmarket.domain.Location;
import java.util.UUID;

public class User {
    private final UUID id;
    private final String fName;
    private final String lName;
    private final String cName;
    private final String phoneNo;
    private final String phoneCode;
    private final String email;
    private final String creationDate;
    private final Location location;
    private final String type;

    public User(UUID id, String fName, String lName, String cName, String phoneNo, String phoneCode, String email, String creationDate, Location location, String type) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.cName = cName;
        this.phoneNo = phoneNo;
        this.phoneCode = phoneCode;
        this.email = email;
        this.creationDate = creationDate;
        this.location = location;
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

    public Location getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }
}
