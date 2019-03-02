package com.shuonai.gm.service.impl;

import com.shuonai.gm.domain.Admin;
import com.shuonai.gm.mapper.AdminMapper;
import com.shuonai.gm.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int insertAdmin(Admin admin) {
        return adminMapper.insertAdmin(admin);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }

    @Override
    public int deleteAdmin(int id) {
        return adminMapper.deleteAdmin(id);
    }

    @Override
    public Admin getAdmin(int id) {
        return adminMapper.getAdmin(id);
    }
}