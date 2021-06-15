package dk.howard.repository;

import dk.howard.domain.*;
import dk.howard.repository.entity.*;
import dk.howard.resource.dto.EmployeeDTO;

import javax.enterprise.context.Dependent;
import java.util.*;
import java.util.stream.Collectors;

@Dependent
class Mapper {
    User map(UserTestPO userTestPO) {
        return new User(
                mapId(userTestPO.getId()),
                mapName(userTestPO.getUserName()),
                mapEmail(userTestPO.getEmail()),
                map(userTestPO.getAddress()));
    }

    Cart map(CartPO cartPO) {
        return new Cart(
                mapId(cartPO.getId()),
                mapName(cartPO.getName()),
                mapItems(cartPO.getItems()));
    }

    Cart map(Cart1PO cartPO) {
        return new Cart(
                mapId(cartPO.getId()),
                mapName(cartPO.getName()),
                mapItems1(cartPO.getItems()));
    }

    List<Cart> mapCarts(List<CartPO> cartPOs) {
        return cartPOs.stream().map(this::map).collect(Collectors.toList());
    }

    Item map(ItemPO itemPO) {
        return new Item(
                mapId(itemPO.getId()),
                mapName(itemPO.getName()),
                itemPO.getPrice());
    }

    Item map(Item1PO itemPO) {
        return new Item(
                mapId(itemPO.getId()),
                mapName(itemPO.getName()),
                itemPO.getPrice());
    }

    List<Item> mapItems(List<ItemPO> itemPOs) {
        if (itemPOs == null || itemPOs.isEmpty()) {
            return Collections.emptyList();
        }
        return itemPOs.stream().map(this::map).collect(Collectors.toList());
    }

    List<Item> mapItems1(List<Item1PO> itemPOs) {
        if (itemPOs == null || itemPOs.isEmpty()) {
            return Collections.emptyList();
        }
        return itemPOs.stream().map(this::map).collect(Collectors.toList());
    }

    List<User> map(List<UserTestPO> userTestPOs) {
        return userTestPOs.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    Id mapId(UUID id) {
        return new Id(id);
    }

    Name mapName(String name) {
        return new Name(name);
    }

    Email mapEmail(String email) {
        return new Email(email);
    }

    Address map(AddressPO addressPO) {
        return new Address(addressPO.getStreet(), addressPO.getCity());
    }

    Project map(ProjectPO projectPO) {
        Set<Employee> employees = projectPO.getEmployees().stream().map(this::mapEmpty).collect(Collectors.toSet());
        Project project = new Project(new Id(projectPO.getId()), projectPO.getTitle(), employees);
        project.getEmployees().forEach(e -> e.getProjects().add(project));
        return project;
    }

    List<Project> mapProjects(List<ProjectPO> projectPOs) {
        return projectPOs.stream().map(this::map).collect(Collectors.toList());
    }


    Employee mapEmpty(EmployeePO employeePO) {
        return new Employee(new Id(employeePO.getId()), new Name(employeePO.getName()), new HashSet<>());
    }

    Employee map(EmployeePO employeePO) {
        Employee employee = new Employee(
                new Id(employeePO.getId()),
                new Name(employeePO.getName()),
                employeePO.getProjects().stream().map(this::mapEmpty).collect(Collectors.toSet()));

        employee.getProjects().forEach(p -> p.getEmployees().add(employee));
        return employee;
    }

    Project mapEmpty(ProjectPO projectPO) {
        return new Project(new Id(projectPO.getId()), projectPO.getTitle(), new HashSet<>());
    }

}
