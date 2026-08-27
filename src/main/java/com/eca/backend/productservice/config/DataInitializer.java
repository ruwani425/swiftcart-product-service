package com.eca.backend.productservice.config;

import com.eca.backend.productservice.model.ProductEntity;
import com.eca.backend.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initProducts(ProductRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                ProductEntity p1 = new ProductEntity();
                p1.setName("Wireless Noise-Canceling Headphones");
                p1.setDescription("Premium over-ear Bluetooth headphones with active noise cancellation.");
                p1.setPrice(199.99);
                p1.setStockQuantity(45);

                ProductEntity p2 = new ProductEntity();
                p2.setName("Smart Fitness Watch");
                p2.setDescription("Water-resistant smartwatch with heart rate tracking and GPS.");
                p2.setPrice(129.50);
                p2.setStockQuantity(80);

                ProductEntity p3 = new ProductEntity();
                p3.setName("Ergonomic Mechanical Keyboard");
                p3.setDescription("RGB backlit mechanical keyboard with tactile switches.");
                p3.setPrice(89.99);
                p3.setStockQuantity(30);

                repository.saveAll(List.of(p1, p2, p3));
            }
        };
    }
}
