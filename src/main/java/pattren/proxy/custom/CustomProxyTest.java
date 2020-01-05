package pattren.proxy.custom;

import pattren.proxy.jdk.XieMu;
import pattren.proxy.staticed.Person;

public class CustomProxyTest {
    public static void main(String[] args) {
        try{
            Person obj = (Person)new CustomMeipo().getInstance(new XieMu());
            System.out.println(obj.getClass());
            obj.findLove();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
