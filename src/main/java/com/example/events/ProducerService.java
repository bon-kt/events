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

    public void sendMessage(Order order) {
        kafkaTemplate.send(topic, order);
    }
}
