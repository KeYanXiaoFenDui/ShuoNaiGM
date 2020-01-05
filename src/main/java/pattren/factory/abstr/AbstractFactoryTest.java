package pattren.factory.abstr;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        MilkFactory factory = new MilkFactory();
        //对于用户而言更加简单了
        //用户只有选择的权利了，保证了程序的健壮性
        System.out.println(factory.getMengniu());
        System.out.println(factory.getSanlu());
        System.out.println(factory.getTelunsu());
        System.out.println(factory.getYili());
    }
}
