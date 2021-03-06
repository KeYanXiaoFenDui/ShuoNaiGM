package com.shuonai.gm.service;

import com.shuonai.gm.domain.Menu;
import org.springframework.stereotype.Service;

@Service
public interface IMenuService {
    public int insertMenu(Menu menu);

    public int updateMenu(Menu menu);

    public int deleteMenu(int id);

    public Menu getMenu(int id);
}