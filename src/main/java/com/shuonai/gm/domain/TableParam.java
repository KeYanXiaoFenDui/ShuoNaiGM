package com.shuonai.gm.domain;

import java.io.Serializable;

public class TableParam implements Serializable {
    private int id;//主键
    private int tableId;//表Id
    private String tableNameCn;//表中文名
    private String tableName;//字段所属表表名
    private String upClassName;//首字母大写类名
    private String lowClassName;//首字母小写类名
    private String dbParamName;//数据库字段名称
    private String dbParamType;//数据库中参数类型
    private String comment;//字段注释
    private String upCaseParam;//驼峰式首字母大写参数
    private String lowCaseParam;//驼峰式首字母小写参数
    private String paramType;//对应java参数类型
    private int ifMainKey;//是否主键[1是/0不是]
    private int ifRelated;//是否与其他表有关联[1有/0无]
    private int status;//状态[1有效/0无效]

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getTableId() { return tableId; }

    public void setTableId(int tableId) { this.tableId = tableId; }

    public String getTableNameCn() { return tableNameCn; }

    public void setTableNameCn(String tableNameCn) { this.tableNameCn = tableNameCn; }

    public String getTableName() { return tableName; }

    public void setTableName(String tableName) { this.tableName = tableName; }

    public String getUpClassName() { return upClassName; }

    public void setUpClassName(String upClassName) { this.upClassName = upClassName; }

    public String getLowClassName() { return lowClassName; }

    public void setLowClassName(String lowClassName) { this.lowClassName = lowClassName; }

    public String getDbParamName() { return dbParamName; }

    public void setDbParamName(String dbParamName) { this.dbParamName = dbParamName; }

    public String getDbParamType() { return dbParamType; }

    public void setDbParamType(String dbParamType) { this.dbParamType = dbParamType; }

    public String getComment() { return comment; }

    public void setComment(String comment) { this.comment = comment; }

    public String getUpCaseParam() { return upCaseParam; }

    public void setUpCaseParam(String upCaseParam) { this.upCaseParam = upCaseParam; }

    public String getLowCaseParam() { return lowCaseParam; }

    public void setLowCaseParam(String lowCaseParam) { this.lowCaseParam = lowCaseParam; }

    public String getParamType() { return paramType; }

    public void setParamType(String paramType) { this.paramType = paramType; }

    public int getIfMainKey() { return ifMainKey; }

    public void setIfMainKey(int ifMainKey) { this.ifMainKey = ifMainKey; }

    public int getIfRelated() { return ifRelated; }

    public void setIfRelated(int ifRelated) { this.ifRelated = ifRelated; }

    public int getStatus() { return status; }

    public void setStatus(int status) { this.status = status; }

}