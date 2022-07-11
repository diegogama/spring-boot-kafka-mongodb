package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ProductKafkaToMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductKafkaToMongodbApplication.class, args);
	}

}
