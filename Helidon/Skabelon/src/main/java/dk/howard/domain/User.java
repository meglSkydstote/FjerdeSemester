package dk.howard.domain;

public class User {
    private final Id id;
    private final Name name;

    public User(Id id, Name name) {
        this.id = id;
        this.name = name;
    }

    public Id getId() {
        return id;
    }

    public Name getName() {
        return name;
    }
}
