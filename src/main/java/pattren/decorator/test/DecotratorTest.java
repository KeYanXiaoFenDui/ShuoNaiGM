package pattren.decorator.test;

import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

public class DecotratorTest {
    public static void main(String[] args) {

        //为了某个实现类在不修改原始类的基础上进行动态的覆盖或者增加方法
        //该实现保持跟原有类的层级关系
        //采用装饰模式
        //实际上是一个非常特殊的适配器模式

        //虽然DataInputStream 功能更强大
        //DataInputStream 同样要实现InputStream
        InputStream in = null;
        FilterInputStream fis = new DataInputStream(in);
    }
}
