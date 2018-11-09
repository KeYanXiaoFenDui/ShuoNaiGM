package com.shuonai.gm.domain.vo;

import java.util.List;

/**
 * Created by Admininstrator on 2018/11/6.
 */
public class ApiObjectVo {
    private String apiName;//接口名称
    private String apiBasePath;//接口访问路径
    private String apiMethod;//接口方法名
    private String apiComment;//作用注释
    private String requestMethod;//请求方法
    private String dataOperation;//数据库操作
    private int ifRollback;//是否报错回滚
    private int ifPages;//是否分页
    private List<ParamObjectVo> params;//入参

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiBasePath() {
        return apiBasePath;
    }

    public void setApiBasePath(String apiBasePath) {
        this.apiBasePath = apiBasePath;
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

    public List<ParamObjectVo> getParams() {
        return params;
    }

    public void setParams(List<ParamObjectVo> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "ApiObjectVo{" +
                "apiName='" + apiName + '\'' +
                ", apiBasePath='" + apiBasePath + '\'' +
                ", apiMethod='" + apiMethod + '\'' +
                ", apiComment='" + apiComment + '\'' +
                ", requestMethod='" + requestMethod + '\'' +
                ", dataOperation='" + dataOperation + '\'' +
                ", ifRollback=" + ifRollback +
                ", ifPages=" + ifPages +
                ", params=" + params +
                '}';
    }
}
