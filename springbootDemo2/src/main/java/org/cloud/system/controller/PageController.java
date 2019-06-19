package org.cloud.system.controller;

import java.util.ArrayList;
import java.util.List;

import org.cloud.common.info.Server;
import org.cloud.system.model.Dept;
import org.cloud.system.model.Emp;
import org.cloud.system.service.IDeptService;
import org.cloud.system.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @Autowired
    private IEmpService empService;
    
    @Autowired
    private IDeptService deptService;

    @GetMapping("/welcome")
    public String welcome(ModelMap model) {
        model.addAttribute("userCount", 2);
        model.addAttribute("roleCount", 2);
        model.addAttribute("menuCount", 12);
        model.addAttribute("loginLogCount", 51);
        model.addAttribute("sysLogCount", 478);
        model.addAttribute("userOnlineCount", 2);
        return "welcome";
    }

    @GetMapping("/weekLoginCount")
    @ResponseBody
    public List<Integer> recentlyWeekLoginCount() {
        List<Integer> recentlyWeekLoginCount = new ArrayList<Integer>();
        recentlyWeekLoginCount.add(10);
        recentlyWeekLoginCount.add(4);
        recentlyWeekLoginCount.add(6);
        recentlyWeekLoginCount.add(9);
        recentlyWeekLoginCount.add(20);
        recentlyWeekLoginCount.add(1);
        recentlyWeekLoginCount.add(13);
        return recentlyWeekLoginCount;
    }

    @GetMapping("/systemInfo")
    public String serverInfo(ModelMap model) throws Exception {
        Server server = new Server();
        server.copyTo();
        model.addAttribute("server", server);
        return "systemInfo";
    }

    @GetMapping("/empView")
    public String empListView(ModelMap model) throws Exception {
        return "emp/emp-list";
    }

    @GetMapping("/empChangeView/{id}")
    public String empUpdatePage(ModelMap model, @PathVariable("id") Long id) throws Exception {
        model.addAttribute("emp", empService.getById(id).orElse(new Emp()));
        model.addAttribute("deptList", deptService.getAll());
        return "emp/emp-add";
    }
    
    @GetMapping("/empChangeView")
    public String empAddPage(ModelMap model) throws Exception {
        model.addAttribute("deptList", deptService.getAll());
        return "emp/emp-add";
    }

    @GetMapping("/deptView")
    public String deptListView(ModelMap model) throws Exception {
        return "dept/dept-list";
    }

    @GetMapping("/deptChangeView/{id}")
    public String deptUpdatePage(ModelMap model, @PathVariable("id") Long id) throws Exception {
        model.addAttribute("dept", deptService.getById(id).orElse(new Dept()));
        return "dept/dept-add";
    }
    
    @GetMapping("/deptChangeView")
    public String deptAddPage(ModelMap model) throws Exception {
        return "dept/dept-add";
    }
}