package org.cloud.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Beetl2Controller {

    @GetMapping("/welcome")
    public String welcome(HttpServletRequest request) {
        request.setAttribute("beetl","官网www.ibeetl.com");
        request.setAttribute("test","springboot 集成 beetl 一起来学呀");
        return "index1.btl";
    }
}
