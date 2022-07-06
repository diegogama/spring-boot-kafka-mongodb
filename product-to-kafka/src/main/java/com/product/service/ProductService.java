package com.product.service;

import com.product.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private static final String TOPIC = "product";

    @Autowired
    private KafkaTemplate<String,Product> kafkaTemplate;

    public void sendMessageKafka(Product product){
        LOGGER.info("Sending product='{}' to topic='{}'", product, TOPIC);
        kafkaTemplate.send(TOPIC, product);
    }

}
