package org.cloud.system.service.impl;

import java.util.List;

import org.cloud.common.base.BaseServiceImpl;
import org.cloud.system.mapper.DeptMapper;
import org.cloud.system.model.Dept;
import org.cloud.system.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

@Service
public class DeptServiceImpl extends BaseServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> getAllByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return deptMapper.selectAll();
    }

}
