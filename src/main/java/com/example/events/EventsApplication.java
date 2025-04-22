package com.example.events;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class EventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsApplication.class, args);
	}

	@Bean
    public ApplicationRunner runner(KafkaTemplate<String, Order> template) {
        return args -> {
			Order o = new Order("Third time", 99);
            template.send("order-completed", "test", o);
        };
    }
}
