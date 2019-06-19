package org.cloud.system.mapper;

import org.apache.ibatis.annotations.Param;
import org.cloud.common.base.BaseMapper;
import org.cloud.system.model.Emp;

public interface EmpMapper extends BaseMapper<Emp> {
    int updateStatusByPrimaryKey(@Param("id") Long id, @Param("status") int status);
}
