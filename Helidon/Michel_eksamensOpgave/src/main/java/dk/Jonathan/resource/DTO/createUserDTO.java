package dk.Jonathan.resource.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dk.Jonathan.domain.Id;
import dk.Jonathan.domain.Name;

import java.util.Date;

public class createUserDTO {
    private final String firstName;
    private final String lastName;
    private final int phone_Number;
    private final String phone_Code;
    private final String email;
    private final Date creationDate;
    private final String type;
    private final String companyName;
    private final String zipCode;

    @JsonCreator
    public createUserDTO(
                         @JsonProperty("_firstName")String firstName,
                         @JsonProperty("_lastName") String lastName,
                         @JsonProperty("_phone_Number") int phone_Number,
                         @JsonProperty("_phone_Code")String phone_Code,
                         @JsonProperty("_email") String email,
                         @JsonProperty("_creationDate")Date creationDate,
                         @JsonProperty("_type") String type,
                         @JsonProperty("_companyName")String companyName,
                         @JsonProperty("_zipCode") String zipCode
                         ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone_Number = phone_Number;
        this.phone_Code = phone_Code;
        this.email = email;
        this.creationDate = creationDate;
        this.type = type;
        this.companyName = companyName;
        this.zipCode = zipCode;
}


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhone_Number() {
        return phone_Number;
    }


    public String getEmail() {
        return email;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getPhone_Code() {
        return phone_Code;
    }

    public String getType() {
        return type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getZipCode() {
        return zipCode;
    }

}
