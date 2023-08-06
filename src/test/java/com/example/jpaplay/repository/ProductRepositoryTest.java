package com.example.jpaplay.repository;

import com.example.jpaplay.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {

        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setActive(true);
        product.setPrice(new BigDecimal(100));
        product.setImageUrl("product1.png");

        Product savedObject = productRepository.save(product);

        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());

    }

    @Test
    void updateUsingSaveMethod() {

        Integer id = 1;
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isPresent()) {

            Product product = productOptional.get();
            product.setName("updated product 1");
            product.setDescription("updated description 1");
            productRepository.save(product);
        }
    }

    @Test
    void saveAllMethod() {

        Product product2 = new Product();
        product2.setName("product 2");
        product2.setDescription("product 2 description");
        product2.setSku("150ABC");
        product2.setActive(true);
        product2.setPrice(new BigDecimal(130));
        product2.setImageUrl("product2.png");

        Product product3 = new Product();
        product3.setName("product 3");
        product3.setDescription("product 3 description");
        product3.setSku("30ABC");
        product3.setActive(false);
        product3.setPrice(new BigDecimal(200));
        product3.setImageUrl("product3.png");

        productRepository.saveAll(List.of(product2, product3));

    }

    @Test
    void deleteByIdMethod() {

        Integer id = 1;
        productRepository.deleteById(1);
    }

    @Test
    void countMethod() {

        System.out.println("entity count: " + productRepository.count());
    }

    @Test
    void existByIdMethod() {

        Integer id = 3;
        boolean isPresent = productRepository.existsById(id);
        System.out.println("entity exists: " + isPresent);
    }
}