package com.pattern.practice.factory.inter;

/**
 * Created by DEllComputer on 2018/5/6.
 *
 * 工厂模式之工厂方法模式
 *
 * 工厂方法模式与简单工厂模式不同的地方:
 * 简单工厂只有一个工厂类,而工厂方法模式有一组实现了相同接口的工厂类
 *
 * 这样设计的好处就是,在我要新增一个Byd类型的车的时候,我只需要新增一个BydFactory这个类,然后实现FactoryFunction这个接口,
 * 而不用去改动原来已经存在的代码,相比于简单工厂模式就符合了面向对象程序设计的开闭原则,但在实际编码中,我们还是简单工厂用得多一些;
 */
public interface FactoryFunction {

    Car createCar();
}
