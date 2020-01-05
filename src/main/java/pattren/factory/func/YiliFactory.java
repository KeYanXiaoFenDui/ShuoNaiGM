package pattren.factory.func;

import pattren.factory.Mengniu;
import pattren.factory.Milk;
import pattren.factory.Yili;

/**
 * 事情变得越来越专业
 */
public class YiliFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Yili();
    }
}
