package org.cloud.system.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.cloud.common.base.BaseServiceImpl;
import org.cloud.system.mapper.RoleMapper;
import org.cloud.system.mapper.UserMapper;
import org.cloud.system.model.Role;
import org.cloud.system.model.RolePermission;
import org.cloud.system.model.User;
import org.cloud.system.model.UserRole;
import org.cloud.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public void changePassword(Long userId, String newPassword) {
        User u = userMapper.selectByPrimaryKey(userId);
        u.setPassword(newPassword);
        userMapper.updateByPrimaryKey(u);
    }

    @Override
    public void correlationRoles(Long userId, Long... roleIds) {
        for (Long roleid : roleIds) {
            userMapper.addUserRole(userId, roleid);
        }
    }

    @Override
    public void uncorrelationRoles(Long userId, Long... roleIds) {
        for (Long roleid : roleIds) {
            userMapper.deleteUserRole(userId, roleid);
        }
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    @Override
    public Set<String> findRoles(String username) {
        Set<String> roles = new HashSet<>();
        User u = userMapper.selectUserByUsername(username);
        List<UserRole> user_roles = u.getUserRoles();
        for (UserRole ur : user_roles) {
            Role r = ur.getRole();
            roles.add(r.getRole());
        }
        return roles;
    }

    @Override
    public Set<String> findPermissions(String username) {
        Set<String> permissions = new HashSet<>();
        User u = userMapper.selectUserByUsername(username);
        List<UserRole> userRoles = u.getUserRoles();
        for (UserRole ur : userRoles) {
            Role role = roleMapper.selectByPrimaryKey(ur.getRole().getId());
            List<RolePermission> rolePermissions = role.getRolePermissions();
            for (RolePermission rolePermission : rolePermissions) {
                String permission = rolePermission.getPermission().getPermission();
                permissions.add(permission);
            }
        }
        return permissions;
    }

    @Override
    public List<User> getPageUsers(int pageNum, int pageSize) {
        return this.getAll(pageNum, pageSize);
    }

    @Override
    public void deleteUserRoles(Long uid) {
        userMapper.deleteUserRoles(uid);
    }

}
