package com.example.jpaplay.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "products",
        schema = "ecommerce"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "product_generator")
    @SequenceGenerator(name = "product_generator", sequenceName = "product_sequence_name", allocationSize = 1)
    private Long id;
    @Column(name = "stock_keeping_unit", nullable = false, unique = true)
    private String sku;
    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean active;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @CreationTimestamp
    private LocalDateTime lastUpdated;

}
