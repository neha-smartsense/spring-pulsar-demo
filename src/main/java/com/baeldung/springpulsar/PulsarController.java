package com.baeldung.springpulsar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PulsarController {

    @Autowired
    private PulsarProducer pulsarProducer;
    private final Logger LOGGER = LoggerFactory.getLogger(PulsarController.class);

    @PostMapping(path = "send-message")
    public void sendMessageToPulsar() {
       LOGGER.info("sending msg to queue");
        try {
            pulsarProducer.sendMessageToPulsarTopic(new User("john.doe@example.com", "John"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping(path = "send-message-str")
    public void sendStringMessageToPulsar() {
        LOGGER.info("sending string msg to queue");
        try {
            pulsarProducer.sendStringMessageToPulsarTopic("eugene@baeldung.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
