package com.shuonai.gm.service;

import com.shuonai.gm.domain.MenuRole;
import org.springframework.stereotype.Service;

@Service
public interface IMenuRoleService {
    public int insertMenuRole(MenuRole menuRole);

    public int updateMenuRole(MenuRole menuRole);

    public int deleteMenuRole(int id);

    public MenuRole getMenuRole(int id);
}