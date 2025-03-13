package com.eddie.product_catalog.Controller;

import com.eddie.product_catalog.Models.User;
import com.eddie.product_catalog.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    // Display the registration form
    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";  // Thymeleaf template: src/main/resources/templates/register.html
    }

    // Process registration
    @PostMapping
    public String register(@ModelAttribute("user") User user, HttpSession session, Model model) {
        try {
            User registeredUser = userService.registerUser(user);
            session.setAttribute("user", registeredUser);
            return "redirect:/"; // Redirect to home page after successful registration
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
}
