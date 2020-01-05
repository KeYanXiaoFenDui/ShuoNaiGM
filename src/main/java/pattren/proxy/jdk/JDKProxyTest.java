package pattren.proxy.jdk;

import pattren.proxy.staticed.Person;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class JDKProxyTest {

    public static void main(String[] args) {
        try {
            Person obj = (Person)new JDK58().getInstance(new XieMu());
            System.out.println(obj.getClass());
            obj.findJob();
//            System.out.println(obj);

            //原理:
            //1.拿到被代理对象的引用,并且获取到它的所有接口,反射获取
            //2.JDK Proxy类重新生成一个新的类,同时新的类要实现被代理类所有实现的接口
            //3.动态生成java代码,把新加的业务逻辑方法由一定的逻辑代码去调用(在代码中体现)
            //4.编译新生成的java代码.class
            //5.再重新加载到jvm中运行
            //以上这个过程就叫字节码重组

            //jdk中有个规范,只要是$开头的一般都是自动生成的

            //通过反编译工具可以查看源代码
            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
            FileOutputStream os = new FileOutputStream("F://$Proxy0.class");
            os.write(bytes);
            os.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
