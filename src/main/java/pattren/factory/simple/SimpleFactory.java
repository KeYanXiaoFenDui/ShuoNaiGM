package pattren.factory.simple;

import pattren.factory.*;

public class SimpleFactory {
    public Milk getMilk(String name){
        if(name.equals("特仑苏")){
            return new Telunsu();
        }else if("伊利".equals(name)){
            return new Yili();
        }else if("蒙牛".equals(name)){
            return new Mengniu();
        }else if("三鹿".equals(name)){
            return new Sanlu();
        }else{
            return null;
        }
    }
}
