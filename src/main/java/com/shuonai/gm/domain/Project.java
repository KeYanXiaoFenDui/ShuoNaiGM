package com.shuonai.gm.domain;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable {
    private int id;//主键
    private String projectName;//项目英文名
    private String projectTitle;//项目标题
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