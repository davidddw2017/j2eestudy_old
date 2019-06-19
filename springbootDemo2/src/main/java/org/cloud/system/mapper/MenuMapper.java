package org.cloud.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.cloud.common.base.BaseMapper;
import org.cloud.system.model.Menu;

public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> getMenuList(@Param("level") int level);
}
