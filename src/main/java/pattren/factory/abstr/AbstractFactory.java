package pattren.factory.abstr;

import pattren.factory.Milk;

/**
 * 抽象工厂是用户的主入口
 * 在Spring中应用得最为广泛的一种设计模式
 * 易于扩展
 */
public abstract class AbstractFactory {
    //公共的逻辑
    //方便于统一管理
    public abstract Milk getMengniu();
    public abstract Milk getYili();
    public abstract Milk getTelunsu();
    public abstract Milk getSanlu();
}
