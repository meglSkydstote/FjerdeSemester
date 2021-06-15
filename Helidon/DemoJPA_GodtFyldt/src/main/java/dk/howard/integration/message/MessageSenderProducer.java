package dk.howard.integration.message;

import io.helidon.common.context.Contexts;
import io.helidon.tracing.jersey.client.internal.TracingContext;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class MessageSenderProducer {

    // no state in this bean

    @Produces  // beware of the wrong produces
    @RequestScoped
    MessageSender createMessageSender() {
        System.out.println("PRODUCES");
        List<String> headers = Contexts.context().flatMap(context -> context.get(TracingContext.class))
                .flatMap(tracingContext -> Optional.ofNullable(tracingContext.inboundHeaders()))
                .orElse(Collections.emptyMap()).get("message-type");
        if (headers.isEmpty() || headers.get(0).equals("email")) {
            return new EmailSender();
        } else if (headers.get(0).equals("sms")) {
            return new SMSSender();
        } else {
            return new EmailSender();
        }
    }

    public void closeSender(@Disposes MessageSender sender) {
        sender.close();
    }

}
