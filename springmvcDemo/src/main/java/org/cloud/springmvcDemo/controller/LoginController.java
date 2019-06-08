package org.cloud.springmvcDemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping(value = "/loginPage")
    public String login() {
        return "login/loginPage";
    }

    @PostMapping("/login")
    public String index(Model model, HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("admin".equals(username) && "password".equals(password)) {
            model.addAttribute("user", username);
            return "login/welcome";
        } else {
            return "login/error";
        }
    }
}
