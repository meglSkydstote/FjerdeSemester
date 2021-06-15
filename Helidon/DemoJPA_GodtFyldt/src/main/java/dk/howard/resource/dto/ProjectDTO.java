package dk.howard.resource.dto;

import java.util.Set;

public class ProjectDTO {
    private final String id;
    private final String title;
    private final Set<EmployeeDTO> employees;

    public ProjectDTO(String id, String title, Set<EmployeeDTO> employees) {
        this.title = title;
        this.employees = employees;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public Set<EmployeeDTO> getEmployees() {
        return employees;
    }
}
