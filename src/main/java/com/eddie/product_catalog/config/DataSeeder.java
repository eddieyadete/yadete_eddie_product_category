package com.eddie.product_catalog.config;

import com.eddie.product_catalog.Models.Category;
import com.eddie.product_catalog.Models.Product;
import com.eddie.product_catalog.Ropository.CategoryRepository;
import com.eddie.product_catalog.Ropository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home and Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics, clothing, home));

        Product phone = new Product();
        phone.setName("Phone");
        phone.setDescription("Great communication device in the market");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(699.99);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("Latest model laptop in the market");
        laptop.setImageUrl("https://placehold.co/600x100");
        laptop.setPrice(999.99);
        laptop.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("Winter Jacket");
        jacket.setDescription("Great for keeping warm");
        jacket.setImageUrl("https://placehold.co/600x200");
        jacket.setPrice(129.99);
        jacket.setCategory(clothing);

        Product coffeeMug = new Product();
        coffeeMug.setName("Coffee Mug");
        coffeeMug.setDescription("Makes a great coffee mug");
        coffeeMug.setImageUrl("https://placehold.co/600x400");
        coffeeMug.setPrice(29.99);
        coffeeMug.setCategory(home);

        Product blender = new Product();
        blender.setName("Blender");
        blender.setDescription("High-speed blender");
        blender.setImageUrl("https://placehold.co/600x300");
        blender.setPrice(89.99);
        blender.setCategory(home);

        productRepository.saveAll(Arrays.asList(phone, laptop, jacket, coffeeMug, blender));
    }
}
