package com.shuonai.gm.service;

import com.shuonai.gm.domain.AdminArticle;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IAdminArticleService {
    public int insertAdminArticle(AdminArticle adminArticle);

    public int updateAdminArticle(AdminArticle adminArticle);

    public int deleteAdminArticle(int id);

    public AdminArticle getAdminArticle(int id);

    public List<AdminArticle> queryArticleByCatalogId(int catalogId);

    public List<AdminArticle> queryArticleByCatalogCode(String catalogCode);

    public List<AdminArticle> queryArticleLikeTitle(String title_like);
}