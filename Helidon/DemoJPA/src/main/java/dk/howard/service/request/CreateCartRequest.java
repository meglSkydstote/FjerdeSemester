package dk.howard.service.request;

import dk.howard.domain.Name;

public class CreateCartRequest {
    private final Name name;

    public CreateCartRequest(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
