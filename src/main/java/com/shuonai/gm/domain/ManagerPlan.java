package com.shuonai.gm.domain;

import java.io.Serializable;
import java.util.Date;

public class ManagerPlan implements Serializable {
    private int sumNumber;//总投数
    private int sumTrue;//总中数
    private double sumRate;//总投命中率
    private int nowNumber;//当前投数
    private int nowTrue;//当前中数
    private double nowRate;//当前命中率
    private int perMoney;//每场投本
    private int sumMoney;//总本金
    private double perToSum;//投本总金比
    private int perMinMoney;//每场投本下限
    private int perMaxMoney;//每场投本上限

    public int getSumTrue() {
        return sumTrue;
    }

    public void setSumTrue(int sumTrue) {
        this.sumTrue = sumTrue;
    }

    public int getNowTrue() {
        return nowTrue;
    }

    public void setNowTrue(int nowTrue) {
        this.nowTrue = nowTrue;
    }

    public int getSumNumber() {
        return sumNumber;
    }

    public void setSumNumber(int sumNumber) {
        this.sumNumber = sumNumber;
    }

    public double getSumRate() {
        return sumRate;
    }

    public void setSumRate(double sumRate) {
        this.sumRate = sumRate;
    }

    public int getNowNumber() {
        return nowNumber;
    }

    public void setNowNumber(int nowNumber) {
        this.nowNumber = nowNumber;
    }

    public double getNowRate() {
        return nowRate;
    }

    public void setNowRate(double nowRate) {
        this.nowRate = nowRate;
    }

    public int getPerMoney() {
        return perMoney;
    }

    public void setPerMoney(int perMoney) {
        this.perMoney = perMoney;
    }

    public int getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(int sumMoney) {
        this.sumMoney = sumMoney;
    }

    public double getPerToSum() {
        return perToSum;
    }

    public void setPerToSum(double perToSum) {
        this.perToSum = perToSum;
    }

    public int getPerMinMoney() {
        return perMinMoney;
    }

    public void setPerMinMoney(int perMinMoney) {
        this.perMinMoney = perMinMoney;
    }

    public int getPerMaxMoney() {
        return perMaxMoney;
    }

    public void setPerMaxMoney(int perMaxMoney) {
        this.perMaxMoney = perMaxMoney;
    }

    @Override
    public String toString() {
        return "ManagerPlan{" +
                "sumNumber=" + sumNumber +
                ", sumTrue=" + sumTrue +
                ", sumRate=" + sumRate +
                ", nowNumber=" + nowNumber +
                ", nowTrue=" + nowTrue +
                ", nowRate=" + nowRate +
                ", perMoney=" + perMoney +
                ", sumMoney=" + sumMoney +
                ", perToSum=" + perToSum +
                ", perMinMoney=" + perMinMoney +
                ", perMaxMoney=" + perMaxMoney +
                '}';
    }
}