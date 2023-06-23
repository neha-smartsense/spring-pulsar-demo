package com.baeldung.springpulsar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PulsarController {

    @Autowired
    private PulsarProducer pulsarProducer;

    @PostMapping(path = "send-message")
    public void sendMessageToPulsar() {
        System.out.println("sending msg to queue");
        try {
            pulsarProducer.sendMessageToPulsarTopic(new User("eugene@baeldung.com", "Eugene"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping(path = "send-message-str")
    public void sendStringMessageToPulsar() {
        System.out.println("sending string msg to queue");
        try {
            pulsarProducer.sendStringMessageToPulsarTopic("eugene@baeldung.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
