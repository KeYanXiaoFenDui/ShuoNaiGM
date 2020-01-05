package pattren.proxy;

import sun.misc.ProxyGenerator;

public class JDKProxyTest {
    //原理：
    //1.拿到被代理对象的引用，并且获取到它的所有的接口，反射获取
    //2.JDK Proxy类重新生成一个新的类，同时新的类要实现被代理类所有实现的接口
    //3.动态生成JAVA代码，把新加的业务逻辑方法由一定的逻辑代码去调用（在代码中体现）
    //4.编译新生成的java代码.class
    //5.再重新加载到jvm中运行
    //以上这个过程就叫做字节码重组

    //jdk中有个规范，只要是$开头的一般都是自动生成的


    public static void main(String[] args) {
        //通过反编译工具可以查看源代码
//        ProxyGenerator.generateProxyClass("$Proxy0",new Class[])
    }
}
