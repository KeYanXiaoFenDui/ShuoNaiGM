package pattren.strategy.pay.payport;

import pattren.strategy.pay.PayState;

public class JDPay implements Payment {
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("欢迎使用京东白条");
        System.out.println("打欠条");
        return new PayState(200,amount,"支付成功");
    }
}
