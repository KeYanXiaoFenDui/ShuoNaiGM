package com.shuonai.gm.mapper;

import com.shuonai.gm.domain.AdminArticle;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface AdminArticleMapper {

    @Insert("INSERT into admin_article (catalog_id,article_title,article_subtitle,article_poster,article_summary,article_content,article_author,type,state,createtime,updatetime) values (#{catalogId},#{articleTitle},#{articleSubtitle},#{articlePoster},#{articleSummary},#{articleContent},#{articleAuthor},#{type},#{state},#{createtime},#{updatetime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insertAdminArticle(AdminArticle adminArticle);

    @Update("UPDATE admin_article SET catalog_id=#{catalogId},article_title=#{articleTitle},article_subtitle=#{articleSubtitle},article_poster=#{articlePoster},article_summary=#{articleSummary},article_content=#{articleContent},article_author=#{articleAuthor},type=#{type},state=#{state},createtime=#{createtime},updatetime=#{updatetime} where id=#{id}")
    public int updateAdminArticle(AdminArticle adminArticle);

    @Delete("delete from admin_article where id=#{id}")
    public int deleteAdminArticle(int id);

    @Select("select * from admin_article where id=#{id}")
    public AdminArticle getAdminArticle(int id);

    @Select("select * from admin_article where catalog_id=#{catalogId} and state = '1'")
    public List<AdminArticle> queryAdminArticleByCatalogId(int catalogId);

    @Select("select * from admin_article a,admin_catalog c where c.catalog_code=#{catalogCode} and c.id = a.catalog_id and c.state = '1' and a.state = '1'")
    public List<AdminArticle> queryAdminArticleByCatalogCode(String catalogCode);

    @Select("select * from admin_article where state = '1' and article_title like concat('%',#{title_like},'%')")
    public List<AdminArticle> queryAdminArticleTitleLike(String title_like);
}