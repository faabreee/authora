package com.authora.infrastructure.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        Object error = request.getSession().getAttribute("LOGIN_ERROR");

        if (error != null) {
            model.addAttribute("error", error.toString());
            request.getSession().removeAttribute("LOGIN_ERROR");
        }

        return "login";
    }
}
