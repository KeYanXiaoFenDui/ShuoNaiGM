package pattren.adapter;

import pattren.adapter.passport.SiginForThirdService;

public class SiginForThirdServiceTest {
    public static void main(String[] args) {
        SiginForThirdService service = new SiginForThirdService();

        //不改变原来的代码,实现新的功能
        //还可以再加一层策略模式
        service.loginForQQ("dfsdfsdff34gge32");
    }
}
