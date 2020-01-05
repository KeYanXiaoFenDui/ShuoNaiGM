package pattren.proxy.custom;

import pattren.proxy.staticed.Person;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CustomMeipo implements GPInvocationHandler{

    //被代理的对象,把引用给保存下来
    private Person target;
    public Object getInstance(Person target) throws Exception{
        this.target = target;

        Class<?> clazz = target.getClass();

        //用来生成一个新的对象(字节码重组来实现)
        return GPProxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆:我要给你找对象,现在已经拿到你的需求");
        System.out.println("开始物色");
        method.invoke(this.target,args);
        System.out.println("如果合适的话,就准备办事");
        return null;
    }
}
