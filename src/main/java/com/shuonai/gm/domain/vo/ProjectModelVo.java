package com.shuonai.gm.domain.vo;


public class ProjectModelVo {
    private String projectName;
    private String projectTitle;
    private String modelName;
    private String modelTitle;

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

    @Override
    public String toString() {
        return "ProjectModelVo{" +
                "projectName='" + projectName + '\'' +
                ", projectTitle='" + projectTitle + '\'' +
                ", modelName='" + modelName + '\'' +
                ", modelTitle='" + modelTitle + '\'' +
                '}';
    }
}
