package dk.howard.service;

import dk.howard.domain.Employee;
import dk.howard.domain.Name;
import dk.howard.domain.Project;
import dk.howard.repository.Repository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Dependent
@Transactional(rollbackOn = Exception.class)
public class EmployeeService {
    private final Repository repository;

    @Inject
    public EmployeeService(Repository repository) {
        this.repository = repository;
    }

    public Employee createEmployee(Name name) {
        return repository.createEmployee(name);
    }

    public List<Project> getAllProjects() {
        return repository.findAllProjects();
    }

}
