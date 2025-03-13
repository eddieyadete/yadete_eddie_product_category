package com.eddie.product_catalog.Controller;

import com.eddie.product_catalog.Models.User;
import com.eddie.product_catalog.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/signin")
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "signin";
    }


    @PostMapping
    public String signin(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
        try {
            User loggedInUser = userService.login(username, password);
            session.setAttribute("user", loggedInUser);
            return "redirect:home";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "signin";
        }
    }
}
