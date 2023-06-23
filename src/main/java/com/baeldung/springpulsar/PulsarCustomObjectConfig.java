package com.baeldung.springpulsar;

import org.apache.pulsar.client.api.Schema;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.pulsar.core.PulsarProducerFactory;
import org.springframework.pulsar.core.PulsarTemplate;

@Configuration
public class PulsarCustomObjectConfig {

    /*@Bean
    public SchemaResolver.SchemaResolverCustomizer<DefaultSchemaResolver> schemaResolverCustomizer() {
        return schemaResolver -> schemaResolver.addCustomSchemaMapping(User.class, Schema.JSON(User.class));
    }*/

    @Bean
    PulsarTemplate<User> pulsarTemplate(PulsarProducerFactory<User> producerFactory) {
        return new PulsarTemplate<>(producerFactory);
    }

    @Bean
    PulsarTemplate<String> pulsarTemplateString(PulsarProducerFactory<String> producerFactory) {
        return new PulsarTemplate<>(producerFactory);
    }

    @Bean
    ApplicationRunner runner3(PulsarProducerFactory<User> producerFactory) {

        String topic = "user-topic-new";
        PulsarTemplate<User> pulsarTemplate = new PulsarTemplate<>(producerFactory);
        return args -> {
            for (int i = 0; i < 10; i++) {
                User foo = new User("eugene@baeldung.com", "Eugene");
                pulsarTemplate.send(topic, foo, Schema.JSON(User.class));
            }
        };
    }
}
