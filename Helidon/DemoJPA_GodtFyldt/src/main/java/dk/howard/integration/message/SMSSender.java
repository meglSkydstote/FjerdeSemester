package dk.howard.integration.message;

import dk.howard.domain.Message;
import dk.howard.domain.User;

public class SMSSender implements MessageSender {

   //private String GIANT_REESOURCE;
    @Override
    public void sendMessage(User user, Message message) {
        System.out.println(String.format("The message sender hash is %s", this.toString()));
        System.out.println(String.format("The message was sent by SMS to %s", user.getName()));
    }

    @Override
    public void close() {
        System.out.println(String.format("The message sender hash is %s and is closing", this.toString()));
        //CLEAN UP GIANT RESOURCE UNDGÅ MEMORY LEAKS
        //SEND  AUDIT BESKED
    }
}
