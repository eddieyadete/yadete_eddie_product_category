package com.eddie.product_catalog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"/","/home"})
    public String home(Model model) {
        model.addAttribute("message", "Welcome to the product catalog");
        return "home";  // This should correspond to src/main/resources/templates/index.html.
    }
}
