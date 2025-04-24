package com.example.events;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    private final KafkaTemplate<String, Order> kafkaTemplate;
    private final String topic = "order-completed";

    public ProducerService(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String key, Order order) {
        kafkaTemplate.send(topic, key, order);
    }
}
