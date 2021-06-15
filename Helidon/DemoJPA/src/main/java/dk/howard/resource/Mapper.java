package dk.howard.resource;

import dk.howard.domain.*;
import dk.howard.resource.dto.*;
import dk.howard.service.request.CreateUserRequest;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class Mapper {

    Id mapId(String id) {
        return new Id(id);
    }

    Name mapName(String id) {
        return new Name(id);
    }

    Email mapEmail(String email) {
        return new Email(email);
    }

    Address mapAddress(String street, String city) {
        return new Address(street, city);
    }

    AddressDTO mapAddress(Address address) {
        return new AddressDTO(address.getStreet(), address.getCity());
    }

    CreateUserRequest map(CreateUserDTO createUserDTO) {
        return new CreateUserRequest(
                mapName(createUserDTO.getName()),
                mapEmail(createUserDTO.getEmail()),
                mapAddress(createUserDTO.getStreet(), createUserDTO.getCity())
        );
    }

    UserDTO map(User user) {
        return new UserDTO(user.getId().toString(), user.getName().getName(), user.getEmail().getEmail(), mapAddress(user.getAddress()));
    }

    List<UserDTO> map(List<User> users) {
        return users.stream().map(this::map).collect(Collectors.toList());
    }

    ProjectDTO map(Project project) {
        return new ProjectDTO(project.getId().toString(),
                project.getTitle(),
                project.getEmployees().stream().map(this::map).collect(Collectors.toSet())
        );
    }

    List<ProjectDTO> mapProjects(List<Project> project) {
        return project.stream().map(this::map).collect(Collectors.toList());
    }

    EmployeeDTO map(Employee employee) {
        return new EmployeeDTO(employee.getName().getName());
    }

    Message map(MessageDTO dto) {
        return new Message(dto.getMessage());
    }

}
