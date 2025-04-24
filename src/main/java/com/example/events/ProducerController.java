package com.example.events;

// this is for test produce and demo the events that generate next/chained events 

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    ProducerService service;
    ProducerController(ProducerService service) {
        this.service = service;
    }
    
    @GetMapping("/events/ordered")
    public String sendOrderCompleted(@RequestParam String item, @RequestParam String setprice) {
        int price = Integer.parseInt(setprice);
        service.sendMessage("orderDept", new Order(item, price));
        return String.format("sendMessage Order %s %d", item, price);
    }

}
