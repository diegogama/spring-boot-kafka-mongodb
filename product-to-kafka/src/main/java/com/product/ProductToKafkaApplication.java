package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class ProductToKafkaApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductToKafkaApplication.class, args);
	}

}
