package pattren.strategy.pay;

import pattren.strategy.pay.payport.PayType;
import pattren.strategy.pay.payport.Payment;

public class Order {
    private String uid;
    private String orderId;
    private double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    //这个参数,完全可以用payment这个接口来代替
    //为什么?不用接口,而用策略代替

    //完美地解决了switch的过程,不需要在代码逻辑中写switch了
    //更不需要写if else if
    public PayState pay(PayType payType){
//        return payment.pay(this.uid,this.amount);
        return payType.get().pay(this.uid,this.amount);
    }
}
