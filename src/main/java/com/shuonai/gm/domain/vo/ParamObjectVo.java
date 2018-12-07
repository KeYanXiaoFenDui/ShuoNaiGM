package com.shuonai.gm.domain.vo;

/**
 * Created by Admininstrator on 2018/11/6.
 */
public class ParamObjectVo {
    private String paramTitle;//中文名称
    private String paramName;//英文名称
    private String paramType;//类型 String int
    private String ifMust;//是否必传 T  F
    private String paramComment;//注释
    private String fatherName;//父节点名称

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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    @Override
    public String toString() {
        return "ParamObjectVo{" +
                "paramTitle='" + paramTitle + '\'' +
                ", paramName='" + paramName + '\'' +
                ", paramType='" + paramType + '\'' +
                ", ifMust='" + ifMust + '\'' +
                ", paramComment='" + paramComment + '\'' +
                ", fatherName='" + fatherName + '\'' +
                '}';
    }
}
