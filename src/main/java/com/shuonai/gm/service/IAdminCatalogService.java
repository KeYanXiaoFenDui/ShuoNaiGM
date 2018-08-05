package com.shuonai.gm.service;

import com.shuonai.gm.domain.AdminCatalog;


public interface IAdminCatalogService {
    public int insertAdminCatalog(AdminCatalog adminCatalog);

    public int updateAdminCatalog(AdminCatalog adminCatalog);

    public int deleteAdminCatalog(int id);

    public AdminCatalog getAdminCatalog(int id);
}