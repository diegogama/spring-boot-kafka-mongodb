package com.product.consumer;


import com.product.model.Product;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "${topic.name}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "productListener")

    public void
    consume(Product product)
    {
        System.out.println("message = " + product);
    }
}