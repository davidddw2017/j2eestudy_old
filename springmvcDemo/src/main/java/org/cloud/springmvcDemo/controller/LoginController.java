package org.cloud.springmvcDemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public String index(ModelMap model) {
        model.addAttribute("message", "Spring MVC Web Application!");
        return "index";
    }

    @GetMapping(value = "/loginPage")
    public String login() {
        return "loginPage";
    }

    @PostMapping("/login")
    public String index(Model model, HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("admin".equals(username) && "password".equals(password)) {
            model.addAttribute("user", username);
            return "welcome";
        } else {
            return "error";
        }
    }
}
