package org.cloud.system.mapper;

import org.cloud.common.base.BaseMapper;
import org.cloud.system.model.Role;

public interface RoleMapper extends BaseMapper<Role> {

    void addRolePermission(long roleid, long permissionid);

    void deleteRolePermission(long roleid, long permissionid);// 删除一个角色和一个权限的关联

    void deleteRoles(long roleid);// 删除一个角色的所有权限关联

}
