package org.cloud.system.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.cloud.common.util.ResultBean;
import org.cloud.system.model.Emp;
import org.cloud.system.service.IEmpService;
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
@RequestMapping("/api/emp")
public class EmpController {

    @Autowired
    private IEmpService service;

    @GetMapping("/list")
    @ResponseBody
    public Map<String, Object> listEmp(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "10")int limit) {
        Map<String, Object> info = new HashMap<>();
        info.put("data", service.getAllByPage(page, limit));
        info.put("count", service.getCount(new Emp()));
        info.put("code", 0);
        return info;
    }
    
    @PostMapping
    @ResponseBody
    public ResultBean addEmp(@RequestBody Emp emp) {
        emp.setUserId(UUID.randomUUID().toString());
        return ResultBean.success(service.save(emp));
    }
    
    @PutMapping
    @ResponseBody
    public ResultBean updateEmp(@RequestBody Emp emp) {
        service.save(emp);
        return ResultBean.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultBean deleteEmp(@PathVariable Long id) {
        service.deleteById(id);
        return ResultBean.success();
    }
    
    @PostMapping("/{id}/disable")
    @ResponseBody
    public ResultBean disable(@PathVariable("id") Long id) {
        return ResultBean.success(service.disableUserByID(id));
    }

    @PostMapping("/{id}/enable")
    @ResponseBody
    public ResultBean enable(@PathVariable("id") Long id) {
        return ResultBean.success(service.enableUserByID(id));
    }

}
