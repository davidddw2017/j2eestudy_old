package org.cloud.system.mapper;

import org.cloud.common.base.BaseMapper;
import org.cloud.system.model.Permission;

public interface PermissionMapper extends BaseMapper<Permission> {
    void deletePermissionsById(Long permissionid);
}
