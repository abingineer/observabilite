package com.codepro.monitoringspringprometheusgraphana;

import com.codepro.monitoringspringprometheusgraphana.entities.Product;
import com.codepro.monitoringspringprometheusgraphana.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

@Bean
CommandLineRunner runner(ProductRepository productRepository) {
        return args -> {
             productRepository.save(
                     Product.builder()
                             .name("Computer")
                             .price(2300)
                             .build()
             );
            productRepository.save(
                    Product.builder()
                            .name("Smart Phone")
                            .price(1200)
                            .build()
            );
            productRepository.save(
                    Product.builder()
                            .name("Printer")
                            .price(300)
                            .build()
            );
            productRepository.findAll().forEach(System.out::println);
        };
    }
}

