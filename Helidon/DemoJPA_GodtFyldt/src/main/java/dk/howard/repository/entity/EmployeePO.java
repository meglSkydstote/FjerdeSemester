package dk.howard.repository.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="EMPLOYEE")
public class EmployeePO {
    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "VARCHAR(40)", nullable = false, updatable = false, unique = true)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "name", columnDefinition = "VARCHAR(40)", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "employees")
    private Set<ProjectPO> projects;

    public EmployeePO() {
    }

    public EmployeePO(String name) {
        this.name = name;
    }

    public Set<ProjectPO> getProjects() {
        return projects;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
