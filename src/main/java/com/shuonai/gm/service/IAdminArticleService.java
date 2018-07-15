package com.shuonai.gm.service;

import com.shuonai.gm.domain.AdminArticle;
import org.springframework.stereotype.Service;

@Service
public interface IAdminArticleService {
    public int insertAdminArticle(AdminArticle adminArticle);

    public int updateAdminArticle(AdminArticle adminArticle);

    public int deleteAdminArticle(int id);

    public AdminArticle getAdminArticle(int id);
}