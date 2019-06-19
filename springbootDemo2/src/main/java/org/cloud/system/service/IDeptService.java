package org.cloud.system.service;

import java.util.List;

import org.cloud.common.base.BaseService;
import org.cloud.system.model.Dept;

public interface IDeptService extends BaseService<Dept> {

    List<Dept> getAllByPage(int pageNum, int pageSize);

}
