package com.shuonai.gm.domain;

import java.io.Serializable;
import java.util.Date;

public class ApiProjectModel implements Serializable {
    private int id;//主键
    private String projectName;//项目英文名称
    private String projectTitle;//项目中文标题
    private String modelName;//模块英文名称
    private String modelTitle;//模块中文标题
    private Date createTime;//创建时间
    private int status;//状态(0无效,,,1有效)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelTitle() {
        return modelTitle;
    }

    public void setModelTitle(String modelTitle) {
        this.modelTitle = modelTitle;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}