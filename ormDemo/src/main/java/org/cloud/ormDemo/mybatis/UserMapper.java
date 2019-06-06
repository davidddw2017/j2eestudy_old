package org.cloud.ormDemo.mybatis;

import org.cloud.ormDemo.model.User;

public interface UserMapper {
    User getUserByName(long id);
}
