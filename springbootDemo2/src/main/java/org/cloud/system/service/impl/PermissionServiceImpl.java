package org.cloud.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.cloud.common.base.BaseServiceImpl;
import org.cloud.system.mapper.PermissionMapper;
import org.cloud.system.model.Permission;
import org.cloud.system.service.IPermissionService;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Resource
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> getPagePermissions(int pageNum, int pageSize) {
        return this.getAll(pageNum, pageSize);
    }

}
