package pattren.strategy.pay.payport;

import pattren.strategy.pay.PayState;

public interface Payment {

//    //每次增加一个支付渠道,我们就要去维护这个接口一次
//    public final static Payment ALI_PAY = new AliPay();
//    public final static Payment WECHAT_PAY = new WechatPay();
//    public final static Payment UNION_PAY = new UnionPay();
//    public final static Payment JD_PAY = new JDPay();

    public PayState pay(String uid, double amount);
}
