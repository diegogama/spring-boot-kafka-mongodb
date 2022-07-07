package com.product.service.impl;

import com.product.model.Product;
import com.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @Value("${topic.name.producer}")
    private String TOPIC;

    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;

    @Transactional
    public void sendMessageKafka(Product product){
        LOGGER.info("Sending product='{}' to topic='{}'", product, TOPIC);

        kafkaTemplate.send(TOPIC, product);
    }

}
