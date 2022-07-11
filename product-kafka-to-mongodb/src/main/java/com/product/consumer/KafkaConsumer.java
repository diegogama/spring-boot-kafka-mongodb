package com.product.consumer;

import com.product.service.SequenceGeneratorService;
import com.product.model.Product;
import com.product.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private static final Logger LOGGER = LogManager.getLogger(KafkaConsumer.class);

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private ProductService productService;

    @KafkaListener(topics = "${topic.name}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "productListener")
    public void consume(Product product) {
        LOGGER.info("Saving consumed kafka data in mongo db: " + product);
        productService.create(product);
    }
}