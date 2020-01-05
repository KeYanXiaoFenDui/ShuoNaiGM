package pattren.factory.func;

import pattren.factory.Milk;
import pattren.factory.Sanlu;
import pattren.factory.Yili;

/**
 * 事情变得越来越专业
 */
public class SanluFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Sanlu();
    }
}
