package com.eddie.product_catalog.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "category_id")//nullable = false)

    private Catalog category;
}
