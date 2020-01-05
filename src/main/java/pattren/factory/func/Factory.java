package pattren.factory.func;

import pattren.factory.Milk;

/**
 * 工厂模型
 */
public interface Factory {
    //工厂必然具有生成产品技能，统一的产品出口
    Milk getMilk();
}
