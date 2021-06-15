package dk.howard.repository.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@NamedQueries({
        @NamedQuery(name = "ProjectPO.findAll", query = "Select c FROM ProjectPO c")
})
@Entity
@Table(name = "PROJECT")
public class ProjectPO {

    public static final String FIND_ALL = "ProjectPO.findAll";

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "VARCHAR(40)", nullable = false, updatable = false, unique = true)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "title", columnDefinition = "VARCHAR(40)", nullable = false)
    private String title;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "EMPLOYEE_PROJECT",
            joinColumns = {@JoinColumn(name = "PROJECT_FK")},
            inverseJoinColumns = {@JoinColumn(name = "EMPLOYEE_FK")})
    private Set<EmployeePO> employees;

    public ProjectPO() {
    }

    public ProjectPO(String title) {
        this.title = title;
    }

    public void add(EmployeePO employee) {
        employees.add(employee);
        employee.getProjects().add(this);
    }

    public void remove(EmployeePO employee) {
        employees.remove(employee);
        employee.getProjects().remove(this);
    }

    public Set<EmployeePO> getEmployees() {
        return employees;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
