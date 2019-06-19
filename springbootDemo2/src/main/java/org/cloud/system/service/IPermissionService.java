package org.cloud.system.service;

import java.util.List;

import org.cloud.common.base.BaseService;
import org.cloud.system.model.Permission;

public interface IPermissionService extends BaseService<Permission> {
    public List<Permission> getPagePermissions(int pagenum, int pagesize);
}
