package org.cloud.system.service;

import java.util.List;

import org.cloud.common.base.BaseService;
import org.cloud.system.model.Menu;

public interface IMenuService extends BaseService<Menu> {
    public List<Menu> getTreeData(int level);
}
