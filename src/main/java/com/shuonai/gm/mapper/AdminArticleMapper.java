package com.shuonai.gm.mapper;

import com.shuonai.gm.domain.AdminArticle;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AdminArticleMapper {

    @Insert("INSERT into admin_article (catalog_id,article_title,article_subtitle,article_poster,article_summary,article_content,article_author,type,createtime,updatetime) values (#{catalogId},#{articleTitle},#{articleSubtitle},#{articlePoster},#{articleSummary},#{articleContent},#{articleAuthor},#{type},#{createtime},#{updatetime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insertAdminArticle(AdminArticle adminArticle);

    @Update("UPDATE admin_article SET catalog_id=#{catalogId},article_title=#{articleTitle},article_subtitle=#{articleSubtitle},article_poster=#{articlePoster},article_summary=#{articleSummary},article_content=#{articleContent},article_author=#{articleAuthor},type=#{type},createtime=#{createtime},updatetime=#{updatetime} where id=#{id}")
    public int updateAdminArticle(AdminArticle adminArticle);

    @Delete("delete from admin_article where id=#{id}")
    public int deleteAdminArticle(int id);

    @Select("select * from admin_article where id=#{id}")
    public AdminArticle getAdminArticle(int id);

}