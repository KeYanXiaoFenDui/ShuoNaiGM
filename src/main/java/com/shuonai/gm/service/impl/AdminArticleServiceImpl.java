package com.shuonai.gm.service.impl;

import com.shuonai.gm.domain.AdminArticle;
import com.shuonai.gm.mapper.AdminArticleMapper;
import com.shuonai.gm.service.IAdminArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminArticleServiceImpl implements IAdminArticleService {
    @Autowired
    private AdminArticleMapper adminArticleMapper;

    @Override
    public int insertAdminArticle(AdminArticle adminArticle) {
        return adminArticleMapper.insertAdminArticle(adminArticle);
    }

    @Override
    public int updateAdminArticle(AdminArticle adminArticle) {
        return adminArticleMapper.updateAdminArticle(adminArticle);
    }

    @Override
    public int deleteAdminArticle(int id) {
        return adminArticleMapper.deleteAdminArticle(id);
    }

    @Override
    public AdminArticle getAdminArticle(int id) {
        return adminArticleMapper.getAdminArticle(id);
    }
}