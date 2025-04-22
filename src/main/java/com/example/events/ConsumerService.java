package com.example.events;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "order-completed", groupId = "myGroup", containerFactory = "kafkaListenerContainerFactory")
    public void eventsReceived(@Payload Order order, ConsumerRecordMetadata meta) {
        System.out.println("TimeStamp : "+ meta.timestamp());
        System.out.println("Order "+order.toString());
    }
}
