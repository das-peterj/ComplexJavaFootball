package se.iths.message.sender;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import se.iths.message.config.JmsConfig;
import se.iths.message.model.MessageObject;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class Sender {

    JmsTemplate jmsTemplate;

    public Sender(JmsTemplate jmsTemplate) {
       this.jmsTemplate = jmsTemplate;
    }

    @Scheduled(fixedRate = 2000)
    public void sendMessage() {

            System.out.println("Sending message...");
            MessageObject messageObject = new MessageObject(UUID.randomUUID(), "Hello from football_queue!", LocalDateTime.now());
            jmsTemplate.convertAndSend(JmsConfig.football_queue, messageObject);
            System.out.println("Message sent!");

    }

}
