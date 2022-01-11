package se.iths.message.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import se.iths.message.config.JmsConfig;
import se.iths.message.model.MessageObject;

@Component
public class Receiver {

    @JmsListener(destination = JmsConfig.football_queue)
    public void listen(@Payload MessageObject messageObject) {
        System.out.println("I got a message");
        System.out.println(messageObject);
    }
}
