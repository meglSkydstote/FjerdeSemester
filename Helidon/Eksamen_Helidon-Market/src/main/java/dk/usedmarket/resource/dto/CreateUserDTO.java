package dk.usedmarket.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DateFormat;
import java.util.Date;

public class CreateUserDTO {
    private final String fName;
    private final String lName;
    private final String cName;
    private final String phoneNo;
    private final String phoneCode;
    private final String email;
    private final String creationDate;
    private final String zip;
    private final String type;

//    {
//        "firstName": "Test",
//            "lastName": "2",
//            "companyName": "testro",
//            "phoneNumber": "88 88 88 88",
//            "phoneCode": "+45",
//            "email": "test@example.io",
//            "zip": "8210",
//            "type": "private"
//    }

    @JsonCreator
    public CreateUserDTO(
            @JsonProperty("firstName") String fName,
            @JsonProperty("lastName") String lName,
            @JsonProperty("companyName") String cName,
            @JsonProperty("phoneNumber") String phoneNo,
            @JsonProperty("phoneCode") String phoneCode,
            @JsonProperty("email") String email,
            @JsonProperty("zip") String zip,
            @JsonProperty("type") String type){
        this.fName = fName;
        this.lName = lName;
        this.cName = cName;
        this.phoneNo = phoneNo;
        this.phoneCode = phoneCode;
        this.email = email;
        Date date = new Date();
        this.creationDate = DateFormat.getDateInstance().format(date);
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

    public String getZip() {
        return zip;
    }

    public String getType() {
        return type;
    }

}
