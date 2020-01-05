package pattren.factory.simple;

import pattren.factory.Telunsu;

import java.text.SimpleDateFormat;

/*
* 小作坊
* */
public class SimpleFactoryTest {
    public static void main(String[] args){
//        System.out.println(new Telunsu().getName());
        SimpleFactory factory = new SimpleFactory();

        //把用户的需求告诉工厂
        //创建产品的过程隐藏了，对于用户而言完全不清楚是怎么产生的
        System.out.println(factory.getMilk("特仑苏"));
        System.out.println(factory.getMilk("伊利"));
        System.out.println(factory.getMilk("蒙牛"));
        System.out.println(factory.getMilk("三鹿"));
    }
}
