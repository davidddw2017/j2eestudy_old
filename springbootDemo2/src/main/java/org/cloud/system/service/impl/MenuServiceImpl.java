package org.cloud.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.cloud.common.base.BaseServiceImpl;
import org.cloud.system.mapper.MenuMapper;
import org.cloud.system.model.Menu;
import org.cloud.system.service.IMenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends BaseServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Resource
    private MenuMapper menuMapper;
    
    @Override
    public List<Menu> getTreeData(int level) {
        return menuMapper.getMenuList(level);
    }

}
