package dk.howard.service.request;

import dk.howard.domain.Address;
import dk.howard.domain.Email;
import dk.howard.domain.Name;

public class CreateUserRequest {
    private final Name name;
    private final Email email;
    private final Address address;

    public CreateUserRequest(Name name, Email email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Name getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
