package org.cloud.system.mapper;

import org.cloud.common.base.BaseMapper;
import org.cloud.system.model.User;

public interface UserMapper extends BaseMapper<User> {

    User selectUserByUsername(String username);

    void deleteUserRole(long userid, long roleid);

    void addUserRole(long userid, long roleid);

    void deleteUserRoles(long uid);

}
