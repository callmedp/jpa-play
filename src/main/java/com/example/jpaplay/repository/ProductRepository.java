package com.example.jpaplay.repository;

import com.example.jpaplay.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
