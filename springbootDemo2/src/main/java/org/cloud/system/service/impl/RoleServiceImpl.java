package org.cloud.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.cloud.common.base.BaseServiceImpl;
import org.cloud.system.mapper.RoleMapper;
import org.cloud.system.model.Role;
import org.cloud.system.service.IRoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, Role> implements IRoleService {
    
    @Resource
    RoleMapper roleMapper;

    @Override
    public List<Role> getPagedRole(int pageNum, int pageSize) {
        return this.getAll(pageNum, pageSize);
    }
    
    @Override
    public void correlationPermissions(Long roleId, Long... permissionIds) {
        for(Long pid:permissionIds){
            roleMapper.addRolePermission(roleId, pid);
        }
    }
    
    @Override
    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
        for(Long pid:permissionIds){
            roleMapper.deleteRolePermission(roleId, pid);
        }
    }

    @Override
    public void deleteRoles(Long roleid) {
        roleMapper.deleteRoles(roleid);
    }

}
