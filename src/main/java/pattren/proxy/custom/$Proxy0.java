package pattren.proxy.custom;

import pattren.proxy.staticed.Person;

import java.lang.reflect.Method;

public class $Proxy0 implements Person {
    GPInvocationHandler h;

    public $Proxy0(GPInvocationHandler h) {
        this.h = h;
    }

    public void zufangzi() {
        try {
            Method m = Person.class.getMethod("zufangzi", new Class[]{});
            this.h.invoke(this, m, null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void findLove() {
        try {
            Method m = Person.class.getMethod("findLove", new Class[]{});
            this.h.invoke(this, m, null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void buy() {
        try {
            Method m = Person.class.getMethod("buy", new Class[]{});
            this.h.invoke(this, m, null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void findJob() {
        try {
            Method m = Person.class.getMethod("findJob", new Class[]{});
            this.h.invoke(this, m, null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
