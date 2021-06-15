package dk.howard.domain;

import java.util.Set;

public class Employee {
    private Id id;
    private Name name;
    private Set<Project> projects;

    public Employee(Id id, Name name, Set<Project> projects) {
        this.id = id;
        this.name = name;
        this.projects = projects;
    }

    public Id getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Set<Project> getProjects() {
        return projects;
    }
}
