package dk.howard.domain;

import java.util.Set;

public class Project {
    private final Id id;
    private final String title;
    private final Set<Employee> employees;

    public Project(Id id, String title, Set<Employee> employees) {
        this.id = id;
        this.title = title;
        this.employees = employees;
    }

    public Id getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }
}
