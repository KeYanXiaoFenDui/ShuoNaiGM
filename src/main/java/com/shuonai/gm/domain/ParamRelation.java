package com.shuonai.gm.domain;

import java.io.Serializable;

public class ParamRelation implements Serializable {
    private int id;//主键
    private String tableA;//表a名称
    private int aId;//a字段id
    private String paramA;//a字段
    private String tableB;//表b名称
    private int bId;//b字段id
    private String paramB;//b字段
    private int aToB;//a表对b表关系[1一对一,2一对多,3多对一,4多对多]
    private int status;//状态[0无效,1有效]

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTableA() {
        return tableA;
    }

    public void setTableA(String tableA) {
        this.tableA = tableA;
    }

    public int getAId() {
        return aId;
    }

    public void setAId(int aId) {
        this.aId = aId;
    }

    public String getParamA() {
        return paramA;
    }

    public void setParamA(String paramA) {
        this.paramA = paramA;
    }

    public String getTableB() {
        return tableB;
    }

    public void setTableB(String tableB) {
        this.tableB = tableB;
    }

    public int getBId() {
        return bId;
    }

    public void setBId(int bId) {
        this.bId = bId;
    }

    public String getParamB() {
        return paramB;
    }

    public void setParamB(String paramB) {
        this.paramB = paramB;
    }

    public int getAToB() {
        return aToB;
    }

    public void setAToB(int aToB) {
        this.aToB = aToB;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}