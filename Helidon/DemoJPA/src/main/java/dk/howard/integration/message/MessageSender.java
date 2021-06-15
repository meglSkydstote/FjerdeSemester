package dk.howard.integration.message;

import dk.howard.domain.Message;
import dk.howard.domain.User;

public interface MessageSender {
    void sendMessage(User user, Message message);

    void close();
}
