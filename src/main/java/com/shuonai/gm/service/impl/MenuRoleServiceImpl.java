package com.shuonai.gm.service.impl;

import com.shuonai.gm.domain.MenuRole;
import com.shuonai.gm.mapper.MenuRoleMapper;
import com.shuonai.gm.service.IMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuRoleServiceImpl implements IMenuRoleService {
    @Autowired
    private MenuRoleMapper menuRoleMapper;

    @Override
    public int insertMenuRole(MenuRole menuRole) {
        return menuRoleMapper.insertMenuRole(menuRole);
    }

    @Override
    public int updateMenuRole(MenuRole menuRole) {
        return menuRoleMapper.updateMenuRole(menuRole);
    }

    @Override
    public int deleteMenuRole(int id) {
        return menuRoleMapper.deleteMenuRole(id);
    }

    @Override
    public MenuRole getMenuRole(int id) {
        return menuRoleMapper.getMenuRole(id);
    }
}