package org.cloud.system.controller;

import javax.annotation.Resource;

import org.cloud.system.service.IMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Resource
    private IMenuService service;

    @GetMapping(value = { "/", "/main" })
    public String index(ModelMap model) {
        model.addAttribute("menus", service.getTreeData(5));
        return "index";
    }
    
}
