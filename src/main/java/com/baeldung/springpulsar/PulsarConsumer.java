package com.baeldung.springpulsar;

import org.apache.pulsar.client.api.SubscriptionType;
import org.apache.pulsar.common.schema.SchemaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.pulsar.annotation.PulsarListener;
import org.springframework.stereotype.Service;

@Service
public class PulsarConsumer {

    private static final String USER_TOPIC = "user-topic";
    private static final String USER_TOPIC_STR = "user-topic-str";
    private final Logger LOGGER = LoggerFactory.getLogger(PulsarConsumer.class);

    @PulsarListener(
            subscriptionName = "user-topic-subscription",
            topics = USER_TOPIC,
            subscriptionType = SubscriptionType.Shared,
            schemaType = SchemaType.JSON
    )
    public void userTopicListener(User user) {
        LOGGER.info("Received user object with email: {}", user.getEmail());
    }

    @PulsarListener(
            subscriptionName = "user-topic-str-subscription",
            topics = USER_TOPIC_STR,
            subscriptionType = SubscriptionType.Shared
    )
    public void userStringTopicListener(String str) {
        LOGGER.info("Received String: {}", str);
    }
}
