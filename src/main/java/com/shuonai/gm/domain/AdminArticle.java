package com.shuonai.gm.domain;

import java.io.Serializable;
import java.util.Date;

public class AdminArticle implements Serializable {
    private int id;//PK
    private int catalogId;//栏目Id
    private String articleTitle;//文章标题
    private String articleSubtitle;//文章副标题
    private String articlePoster;//文章海报图
    private String articleSummary;//文章简介
    private String articleContent;//文章正文
    private String articleAuthor;//文章作者
    private String type;//0' COMMENT '0 - 普通文章
    private String state;//0 - 无效；1 - 正常；2 - 已删除
    private Date createtime;//创建时间
    private Date updatetime;//更新时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleSubtitle() {
        return articleSubtitle;
    }

    public void setArticleSubtitle(String articleSubtitle) {
        this.articleSubtitle = articleSubtitle;
    }

    public String getArticlePoster() {
        return articlePoster;
    }

    public void setArticlePoster(String articlePoster) {
        this.articlePoster = articlePoster;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}