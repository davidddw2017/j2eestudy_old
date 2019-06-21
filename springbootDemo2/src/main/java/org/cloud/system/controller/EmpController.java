package org.cloud.system.controller;

import java.util.UUID;

import javax.annotation.Resource;

import org.cloud.common.util.PageResultBean;
import org.cloud.common.util.ResultBean;
import org.cloud.system.model.Emp;
import org.cloud.system.service.IEmpService;
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

    @Resource
    private IEmpService service;

    @GetMapping("/list")
    @ResponseBody
    public PageResultBean<Emp> listEmp(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "10")int limit) {
        return new PageResultBean<Emp>(service.getCount(new Emp()), service.getAllByPage(page, limit));
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
