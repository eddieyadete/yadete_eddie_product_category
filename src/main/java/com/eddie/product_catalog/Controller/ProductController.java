package com.eddie.product_catalog.Controller;

import com.eddie.product_catalog.Models.Product;
import com.eddie.product_catalog.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String showProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }
    @GetMapping("/product/new")
    public String showNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product_form";
    }
//    @GetMapping("/product/edit/{id}")
//    public String showEditProductForm(@PathVariable Long id, Model model) {
//        Product product = productService.getAllProducts().stream()
//                .filter(p -> p.getId().equals(id))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Product not found"));
//        model.addAttribute("product", product);
//        return "product_form";
//    }
    @GetMapping("/product/edit/{id}")
    public String showEditProductForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product_form";
    }


//    @GetMapping("/category/{categoryId}")
//    @ResponseBody
//    public List<Product> getProductsByCategory(@PathVariable Long categoryId) {
//        return productService.findByCategory(categoryId);
//    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        if (product.getId() != null) {
            productService.updateProduct(product.getId(), product);
        } else {
            productService.createProduct(product);
        }
        return "redirect:/products";
    }
    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
