package pattren.factory.func;

import pattren.factory.Milk;
import pattren.factory.Telunsu;

/**
 * 事情变得越来越专业
 */
public class TelunsuFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Telunsu();
    }
}
