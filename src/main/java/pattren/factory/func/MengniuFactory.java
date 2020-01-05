package pattren.factory.func;

import pattren.factory.Mengniu;
import pattren.factory.Milk;
import pattren.factory.Telunsu;

/**
 * 事情变得越来越专业
 */
public class MengniuFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Mengniu();
    }
}
