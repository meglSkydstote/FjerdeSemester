package dk.usedmarket.service.request;

import java.util.Date;

public class CreateUserRequest {
    private final String fName;
    private final String lName;
    private final String cName;
    private final String phoneNo;
    private final String phoneCode;
    private final String email;
    private final String creationDate;
    private final String zip;
    private final String type;

    public CreateUserRequest(String fName, String lName, String cName, String phoneNo, String phoneCode, String email, String creationDate, String zip, String type) {
        this.fName = fName;
        this.lName = lName;
        this.cName = cName;
        this.phoneNo = phoneNo;
        this.phoneCode = phoneCode;
        this.email = email;
        this.creationDate = creationDate;
        this.zip = zip;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public String getZip() {
        return zip;
    }
}