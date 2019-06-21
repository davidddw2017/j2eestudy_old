package org.cloud.system.service.impl;

import org.cloud.common.base.BaseServiceImpl;
import org.cloud.system.mapper.DeptMapper;
import org.cloud.system.model.Dept;
import org.cloud.system.service.IDeptService;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl extends BaseServiceImpl<DeptMapper, Dept> implements IDeptService {

}
