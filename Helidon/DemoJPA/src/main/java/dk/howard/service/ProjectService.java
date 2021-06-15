package dk.howard.service;

import dk.howard.domain.Id;
import dk.howard.domain.Project;
import dk.howard.service.exception.InputException;
import dk.howard.service.exception.Sid;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Dependent
@Transactional(rollbackOn = Exception.class)
public class ProjectService {

    private final ProjectService2 projectService2;

    @Inject
    public ProjectService(ProjectService2 service2) {
        this.projectService2 = service2;
    }


    public Project createProject(String title) {
        if (title.length() > 5) {
            throw new InputException(Sid.TITLE_INPUT_ERROR, "Titlen må ikke have længde større end 5");
        }
        Project p = projectService2.createProject(title);
        return p;
    }

    public List<Project> getAllProjects() {
        return projectService2.getAllProjects();
    }

    public void addEmployee(Id projectId, Id employeeId) {
        projectService2.addEmployee(projectId, employeeId);
    }

    public void removeEmployee(Id projectId, Id employeeId) {
        projectService2.removeEmployee(projectId, employeeId);
    }
}
