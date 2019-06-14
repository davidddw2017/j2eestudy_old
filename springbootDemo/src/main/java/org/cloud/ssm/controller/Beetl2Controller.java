package org.cloud.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class Beetl2Controller {

    @GetMapping("/")
    public ModelAndView welcome(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("beetl", "官网www.ibeetl.com");
        modelAndView.addObject("test", "springboot 集成 beetl 一起来学呀");
        modelAndView.setViewName("student");
        return modelAndView;
    }
}
