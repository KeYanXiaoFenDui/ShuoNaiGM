package com.shuonai.gm.domain;

import java.io.Serializable;
import java.util.Date;

public class Api implements Serializable {
    private int id;//主键
    private String apiName;//接口名称
    private String basePath;//接口访问基础路径
    private String apiMethod;//接口方法名
    private String apiComment;//作用注释
    private String requestMethod;//请求方法
    private String dataOperation;//数据库操作
    private int ifRollback;//是否报错回滚
    private int ifPages;//是否分页
    private Date createTime;//创建时间
    private Date updateTime;//修改时间
    private int status;//状态(1有效,0无效)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getApiMethod() {
        return apiMethod;
    }

    public void setApiMethod(String apiMethod) {
        this.apiMethod = apiMethod;
    }

    public String getApiComment() {
        return apiComment;
    }

    public void setApiComment(String apiComment) {
        this.apiComment = apiComment;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getDataOperation() {
        return dataOperation;
    }

    public void setDataOperation(String dataOperation) {
        this.dataOperation = dataOperation;
    }

    public int getIfRollback() {
        return ifRollback;
    }

    public void setIfRollback(int ifRollback) {
        this.ifRollback = ifRollback;
    }

    public int getIfPages() {
        return ifPages;
    }

    public void setIfPages(int ifPages) {
        this.ifPages = ifPages;
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