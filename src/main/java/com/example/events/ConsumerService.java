package com.example.events;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConsumerService {

    @KafkaListener(topics = "order-completed", groupId = "myGroup", containerFactory = "kafkaListenerContainerFactory")
    public void eventsReceived(@Payload Order order, ConsumerRecordMetadata meta) {
        log.info("TimeStamp : "+ meta.timestamp());
        log.info("Order "+order.toString());

        log.info("พอเห็นว่ามี order completed มาแล้วคุณอาจจะอยากเอาราคาไปคำนวณแต็มสะสมของบุคคลดังกล่าว ทำที่ microservice นีั้แล้วก็เกิด event ที่ว่า loyalty point added! เป็นต้น");
    }
}
