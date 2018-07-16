package com.shuonai.gm.domain;

import java.io.Serializable;
import java.util.Date;

public class AdminCatalog implements Serializable {
    private int id;//PK
    private int catalogPid;//0' COMMENT '父栏目id，根栏目id为0
    private String catalogCode;//栏目代码，做类型区分
    private String catalogName;//栏目名称
    private String catalogPoster;//栏目海报图url
    private String catalogSummary;//栏目简介
    private String state;//0 - 无效；1 - 正常；2 - 已删除
    private Date createtime;//
    private Date updatetime;//

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCatalogPid() {
        return catalogPid;
    }

    public void setCatalogPid(int catalogPid) {
        this.catalogPid = catalogPid;
    }

    public String getCatalogCode() {
        return catalogCode;
    }

    public void setCatalogCode(String catalogCode) {
        this.catalogCode = catalogCode;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogPoster() {
        return catalogPoster;
    }

    public void setCatalogPoster(String catalogPoster) {
        this.catalogPoster = catalogPoster;
    }

    public String getCatalogSummary() {
        return catalogSummary;
    }

    public void setCatalogSummary(String catalogSummary) {
        this.catalogSummary = catalogSummary;
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