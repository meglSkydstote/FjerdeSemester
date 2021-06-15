package dk.howard.service;

import dk.howard.domain.Id;
import dk.howard.domain.Message;
import dk.howard.domain.Name;
import dk.howard.domain.User;
import dk.howard.integration.message.MessageSender;
import dk.howard.repository.Repository;
import dk.howard.service.request.CreateUserRequest;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Transactional(rollbackOn = Exception.class)
@Dependent
public class Service {

    private final Repository repository;
    private final MessageSender messageSender;  // ny for hver request da produceren siger at det skal være instantiering på requestScope

    @Inject
    public Service(Repository repository, MessageSender messageSender) {
        this.repository = repository;
        this.messageSender = messageSender;
    }

    public void createUser(CreateUserRequest request) {
        repository.createUser(request.getName(), request.getEmail(), request.getAddress());
    }

    public User findByName(Name name) {
        return repository.findUserByName(name);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public void sendMessage(Id userId, Message message) {
        User user = repository.findUserById(userId);
        messageSender.sendMessage(user, message);
    }

}
