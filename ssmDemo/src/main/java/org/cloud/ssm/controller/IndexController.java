package org.cloud.ssm.controller;

import org.cloud.ssm.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    
    @RequestMapping("/restStudent")
    public ModelAndView restStudent() {
        return new ModelAndView("student","command",new Student());
    }
}
