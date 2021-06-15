package dk.howard.repository;

import dk.howard.domain.*;
import dk.howard.repository.entity.*;
import dk.howard.repository.entitymanager.DemoEntityManager;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Dependent
@Transactional(value = Transactional.TxType.MANDATORY)
public class Repository {
    private final EntityManager entityManager;
    private final Mapper mapper;

    @Inject
    public Repository(DemoEntityManager entityManager, Mapper mapper) {
        this.entityManager = entityManager.getEntityManager();
        this.mapper = mapper;
    }

    public Project createProject(String title) {
        ProjectPO projectPO = new ProjectPO(title);
        entityManager.persist(projectPO);
        return mapper.mapEmpty(projectPO);
    }

    public List<Project> findAllProjects() {
        return mapper.mapProjects(entityManager.createNamedQuery(ProjectPO.FIND_ALL, ProjectPO.class).getResultList());
    }

    public Employee createEmployee(Name name) {
        EmployeePO employeePO = new EmployeePO(name.getName());
        entityManager.persist(employeePO);
        return mapper.mapEmpty(employeePO);
    }

    public void addEmployeeToProject(Id projectId,Id employeeId) {
        EmployeePO employeePO = entityManager.find(EmployeePO.class, employeeId.getId());
        ProjectPO projectPO = entityManager.find(ProjectPO.class, projectId.getId());
        projectPO.add(employeePO);
    }

    public void removeEmployeeFromProject(Id projectId,Id employeeId) {
        EmployeePO employeePO = entityManager.find(EmployeePO.class, employeeId.getId());
        ProjectPO projectPO = entityManager.find(ProjectPO.class, projectId.getId());
        projectPO.remove(employeePO);
    }

    public void createUser(Name name, Email email, Address address) {
        AddressPO addressPO = new AddressPO(address.getStreet(), address.getCity());
        UserTestPO userTestPO = new UserTestPO(name.getName(), email.getEmail(), addressPO);
        entityManager.persist(userTestPO);
    }

    public Cart createCart(Name name) {
        CartPO cartPO = new CartPO(name.getName());
        entityManager.persist(cartPO);
        return mapper.map(cartPO);
    }

    public Cart createItem(Id cartId, Name name, double price) {
        CartPO cartPO = entityManager.find(CartPO.class, cartId.getId());
        ItemPO itemPO = new ItemPO(name.getName(), price);
        cartPO.add(itemPO);
        entityManager.persist(itemPO);
        return mapper.map(cartPO);
    }

    public Cart createCart1(Name name) {
        Cart1PO cartPO = new Cart1PO(name.getName());
        entityManager.persist(cartPO);
        return mapper.map(cartPO);
    }

    public Cart createItem1(Id cartId, Name name, double price) {
        Cart1PO cartPO = entityManager.find(Cart1PO.class, cartId.getId());
        Item1PO itemPO = new Item1PO(name.getName(), price, cartPO);
        cartPO.add(itemPO);
        entityManager.persist(itemPO);
        return mapper.map(cartPO);
    }

    public Cart createItem2(Id cartId, Name name, double price) {
        Cart1PO cartPO = entityManager.find(Cart1PO.class, cartId.getId());
        Item1PO itemPO = new Item1PO(name.getName(), price);
        cartPO.add(itemPO);
        entityManager.persist(itemPO);
        return mapper.map(cartPO);
    }


    public List<Cart> findAllCarts() {
        List<CartPO> cartPOS = entityManager.createNamedQuery(UserTestPO.FIND_ALL_J, CartPO.class).getResultList();
        return mapper.mapCarts(cartPOS);
    }

    public List<User> findAll() {
        List<UserTestPO> pos = entityManager.createNamedQuery(UserTestPO.FIND_ALL_J, UserTestPO.class).getResultList();
        return mapper.map(pos);
    }

    public User findUserById(Id id) {
        UserTestPO po = entityManager.find(UserTestPO.class, id.getId());
        return mapper.map(po);
    }

    public User findUserByName(Name name) {
        UserTestPO userTestPO = findByName(name.getName());
        return mapper.map(userTestPO);
    }

    private UserTestPO findByName(String name) {
        try {
            return entityManager.createNamedQuery(UserTestPO.FIND_BY_NAME, UserTestPO.class)
                    .setParameter(UserTestPO.NAME_PARAMETER, name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
