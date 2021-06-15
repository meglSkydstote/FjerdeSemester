package dk.howard.integration.message;

import dk.howard.domain.Message;
import dk.howard.domain.User;

public class EmailSender implements MessageSender {
    @Override
    public void sendMessage(User user, Message message) {
        System.out.println(String.format("The message sender hash is %s", this.toString()));
        System.out.println(String.format("The message was sent by Email to %s", user.getEmail()));
    }

    @Override
    public void close() {
        System.out.println(String.format("The message sender hash is %s and is closing", this.toString()));
    }
}
