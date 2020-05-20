package com.schibsted.spain.realCustomer.service.consumer;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfigApi {
    @Value(value = "${spring.kafka.bootstrapAddress}")
    private String bootstrapAddress2;
    //@Value(value = "${message.topic.name}")
    private String topicName;

    //@Value(value = "${partitioned.topic.name}")
    private String partionedTopicName;

    //@Value(value = "${filtered.topic.name}")
    private String filteredTopicName;

    //@Value(value = "${greeting.topic.name}")
    private String greetingTopicName;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress2);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic1() {
        return new NewTopic("baeldung", 1, (short) 1);
    }
}
