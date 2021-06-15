package dk.howard.service;

import dk.howard.domain.Id;
import dk.howard.domain.Project;
import dk.howard.repository.Repository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Dependent
@Transactional(rollbackOn = Exception.class)
public class ProjectService2 {
    private final Repository repository;

    @Inject
    public ProjectService2(Repository repository) {
        this.repository = repository;
    }


    public Project createProject(String title) {
        return repository.createProject(title);
    }


    public List<Project> getAllProjects() {
        return repository.findAllProjects();
    }

    public void addEmployee(Id projectId, Id employeeId) {
        repository.addEmployeeToProject(projectId, employeeId);
    }

    public void removeEmployee(Id projectId, Id employeeId) {
        repository.removeEmployeeFromProject(projectId, employeeId);
    }
}
