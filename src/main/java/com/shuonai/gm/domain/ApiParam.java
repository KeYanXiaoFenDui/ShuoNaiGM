package com.shuonai.gm.domain;

import java.io.Serializable;
import java.util.Date;

public class ApiParam implements Serializable {
    private int id;//主键
    private int apiId;//Api主键
    private int paramInOutType;//参数输入输出类型(1输入,2输出)
    private int parentId;//父参数Id
    private String paramTitle;//中文名称
    private String paramName;//英文名称
    private String paramType;//参数类型
    private String ifMust;//是否必传(T是,F否)
    private String paramComment;//注释
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private int status;//状态(1有效,0无效)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public int getParamInOutType() {
        return paramInOutType;
    }

    public void setParamInOutType(int paramInOutType) {
        this.paramInOutType = paramInOutType;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getParamTitle() {
        return paramTitle;
    }

    public void setParamTitle(String paramTitle) {
        this.paramTitle = paramTitle;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getIfMust() {
        return ifMust;
    }

    public void setIfMust(String ifMust) {
        this.ifMust = ifMust;
    }

    public String getParamComment() {
        return paramComment;
    }

    public void setParamComment(String paramComment) {
        this.paramComment = paramComment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}