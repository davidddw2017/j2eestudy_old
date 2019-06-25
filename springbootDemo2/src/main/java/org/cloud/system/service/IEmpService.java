package org.cloud.system.service;

import java.util.List;

import org.cloud.common.base.BaseService;
import org.cloud.system.model.Emp;

public interface IEmpService extends BaseService<Emp> {

    List<Emp> getAllByCondition(String username, String deptName, int pageNum, int pageSize);

    Long getCountByCondition(String username, String deptName);

    Long saveBatch(List<Emp> list);

    Long updateBatch(List<Emp> list);

    boolean disableUserByID(Long id);

    boolean enableUserByID(Long id);
}
