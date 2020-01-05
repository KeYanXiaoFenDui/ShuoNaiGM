package pattren.proxy.cglib;

public class CglibTest {
    public static void main(String[] args) {
        try {
            ZhangSan obj = (ZhangSan)new CGLIBMeipo().getInstance(ZhangSan.class);
            obj.findLove();
            System.out.println("----------------------------");
            System.out.println(obj.getClass());
//            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
