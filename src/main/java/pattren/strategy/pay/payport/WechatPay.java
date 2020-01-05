package pattren.strategy.pay.payport;

import pattren.strategy.pay.PayState;

public class WechatPay implements Payment {
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("欢迎使用微信支付");
        System.out.println("直接从微信红包扣款");
        return new PayState(200,amount,"支付成功");
    }
}
