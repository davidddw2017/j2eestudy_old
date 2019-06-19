package org.cloud.system.controller;

import java.util.HashMap;
import java.util.Map;

import org.cloud.common.util.ResultBean;
import org.cloud.system.model.Dept;
import org.cloud.system.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dept")
public class DeptController {

    @Autowired
    private IDeptService service;

    @GetMapping("/list")
    @ResponseBody
    public Map<String, Object> listDept(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "10")int limit) {
        Map<String, Object> info = new HashMap<>();
        info.put("data", service.getAllByPage(page, limit));
        info.put("count", service.getCount(new Dept()));
        info.put("code", 0);
        return info;
    }
    
    @PostMapping
    @ResponseBody
    public ResultBean addDept(@RequestBody Dept dept) {
        return ResultBean.success(service.save(dept));
    }
    
    @PutMapping
    @ResponseBody
    public ResultBean updateDept(@RequestBody Dept dept) {
        service.save(dept);
        return ResultBean.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultBean deleteDept(@PathVariable Long id) {
        service.deleteById(id);
        return ResultBean.success();
    }
    
}
