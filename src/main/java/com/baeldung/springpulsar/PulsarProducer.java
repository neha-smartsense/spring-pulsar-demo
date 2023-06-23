package com.baeldung.springpulsar;

import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.stereotype.Component;

@Component
public class PulsarProducer {

    @Autowired
    private PulsarTemplate<User> template;
    @Autowired
    private PulsarTemplate<String> stringTemplate;

    private static final String USER_TOPIC = "user-topic";
    private static final String USER_TOPIC_STR = "user-topic-str";

    public void sendMessageToPulsarTopic(User user) throws PulsarClientException {
        /*template.newMessage(user)
                .withTopic(USER_TOPIC)
                .withSchema(Schema.JSON(User.class))
                .send();*/
        template.send(USER_TOPIC, user, Schema.JSON(User.class));
    }

    public void sendStringMessageToPulsarTopic(String str) throws PulsarClientException {
        stringTemplate.send(USER_TOPIC_STR, str);
    }
}
