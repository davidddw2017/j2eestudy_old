package org.cloud.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.cloud.common.base.BaseMapper;
import org.cloud.system.model.Emp;

public interface EmpMapper extends BaseMapper<Emp> {
    List<Emp> selectAllOrderBy(@Param("column") String column, @Param("orderDir") String orderDir);

    int updateStatusByPrimaryKey(@Param("id") Long id, @Param("status") int status);
}
