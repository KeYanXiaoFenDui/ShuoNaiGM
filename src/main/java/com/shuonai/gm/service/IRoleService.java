package com.shuonai.gm.service;

import com.shuonai.gm.domain.Role;
import org.springframework.stereotype.Service;

@Service
public interface IRoleService {
    public int insertRole(Role role);

    public int updateRole(Role role);

    public int deleteRole(int id);

    public Role getRole(int id);
}