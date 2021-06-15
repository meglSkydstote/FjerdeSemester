package dk.Jonathan.domain;

import java.util.Date;

public class UserInfo {
    private final Name name;
    private final int phone_number;
    private final String phone_code;
    private final String email;
    private final String type;
    private final String companyName;

    public UserInfo(Name name, int phone_number, String phone_code, String email, String type, String companyName) {
        this.name = name;
        this.phone_number = phone_number;
        this.phone_code = phone_code;
        this.email = email;
        this.type = type;
        this.companyName = companyName;
    }

    public Name getName() {
        return name;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public String getPhone_code() {
        return phone_code;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }

    public String getCompanyName() {
        return companyName;
    }
}
