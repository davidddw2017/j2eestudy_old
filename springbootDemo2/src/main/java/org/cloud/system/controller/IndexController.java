package org.cloud.system.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.cloud.common.info.Server;
import org.cloud.system.model.Emp;
import org.cloud.system.model.Menu;
import org.cloud.system.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    private static List<Menu> menus = new ArrayList<Menu>();

    @Autowired
    private EmpService service;

    static {
        List<Menu> children = Arrays
                .asList(new Menu[] { new Menu(3, "系统管理", "/systemInfo", "layui-icon-picker-securityscan", null),
                        new Menu(2, "雇员管理", "/empView", "layui-icon-picker-securityscan", null) });
        Menu menu = new Menu(1, "权限管理", "", "layui-icon-picker-securityscan", children);
        menus.add(menu);
    }

    @GetMapping(value = { "/", "/main" })
    public String index(ModelMap model) {
        model.addAttribute("menus", menus);
        return "index";
    }

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
    public String updatePage(ModelMap model, @PathVariable("id") Long id) throws Exception {
        model.addAttribute("emp", service.getById(id).orElse(new Emp()));
        return "emp/emp-add";
    }
    
    @GetMapping("/empChangeView")
    public String addPage(ModelMap model) throws Exception {
        return "emp/emp-add";
    }

}
