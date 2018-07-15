package com.shuonai.gm.service.impl;

import com.shuonai.gm.domain.AdminCatalog;
import com.shuonai.gm.mapper.AdminCatalogMapper;
import com.shuonai.gm.service.IAdminCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminCatalogServiceImpl implements IAdminCatalogService {
    @Autowired
    private AdminCatalogMapper adminCatalogMapper;

    @Override
    public int insertAdminCatalog(AdminCatalog adminCatalog) {
        return adminCatalogMapper.insertAdminCatalog(adminCatalog);
    }

    @Override
    public int updateAdminCatalog(AdminCatalog adminCatalog) {
        return adminCatalogMapper.updateAdminCatalog(adminCatalog);
    }

    @Override
    public int deleteAdminCatalog(int id) {
        return adminCatalogMapper.deleteAdminCatalog(id);
    }

    @Override
    public AdminCatalog getAdminCatalog(int id) {
        return adminCatalogMapper.getAdminCatalog(id);
    }
}