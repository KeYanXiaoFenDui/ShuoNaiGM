package pattren.proxy.jdk;

import pattren.proxy.staticed.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDK58 implements InvocationHandler{
    //被代理的对象,把引用给保存下来
    private Person target;
    public Object getInstance(Person target) throws Exception{
        this.target = target;

        Class<?> clazz = target.getClass();

        //用来生成一个新的对象(字节码重组来实现)
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是58:我要给你找工作,现在已经拿到你的简历");
        System.out.println("开始投递");
        method.invoke(this.target,args);
        System.out.println("安排面试");
        return null;
    }
}
