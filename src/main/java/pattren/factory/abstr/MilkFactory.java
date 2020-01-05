package pattren.factory.abstr;

import pattren.factory.Mengniu;
import pattren.factory.Milk;
import pattren.factory.Yili;
import pattren.factory.func.MengniuFactory;
import pattren.factory.func.SanluFactory;
import pattren.factory.func.TelunsuFactory;
import pattren.factory.func.YiliFactory;

public class MilkFactory extends AbstractFactory {
    @Override
    public Milk getMengniu() {
        return new MengniuFactory().getMilk();
    }

    @Override
    public Milk getYili() {
        return new YiliFactory().getMilk();
    }

    @Override
    public Milk getTelunsu() {
        return new TelunsuFactory().getMilk();
    }

    @Override
    public Milk getSanlu() {
        return new SanluFactory().getMilk();
    }
}
