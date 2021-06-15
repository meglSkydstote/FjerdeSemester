package dk.howard.domain;

public class User {
    private final Id id;
    private final Name name;
    private final Email email;
    private final Address address;

    public User(Id id, Name name, Email email, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Id getId() {
        return id;
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
