package com.pattern.practice.factory;

import com.pattern.practice.factory.inter.*;
import com.pattern.practice.factory.inter.impl.AudiFactory;
import com.pattern.practice.factory.inter.impl.LuxuryCarFactory;


/**
 * Created by DEllComputer on 2018/5/6.
 *
 * 工厂模式:实现了创建者与调用者的分离
 * 分类:简单工厂模式;工厂方法模式;抽象工厂模式;
 *
 *
 * 面向对象设计的基本原则:
 * 1 开闭原则:一个软件的实体应当对扩展开放,对修改关闭.通俗点说就是我们的类实现了一些功能,现在我们要增加新的功能,最好能设计成增加新类来实现,而不是去修改原来的类
 * 2 依赖关系倒转原则:要针对接口编程,不要针对实现编程
 * 3 迪米特法则:通俗的说就是一个类要尽量少依赖于其他类
 */

public class TestClient {

    public static void main(String[] args) {
//测试简单工厂模式        new TestClient().testEasyCarFactory("奥迪");
//测试工厂方法模式        new TestClient().testFactoryFunction();
//测试抽象工厂模式          new TestClient().testAbstractFactory();
    }

    /**
     * 测试简单工厂
     * */
    public void testEasyCarFactory(String type){
        Car car = EasyCarFactory.createCar(type);
        car.run();
    }

    /**
     * 测试工厂方法模式
     * */
    public void testFactoryFunction(){
        FactoryFunction audiFactory = new AudiFactory();
        Car audi = audiFactory.createCar();
        audi.run();
    }

    /**
     * 测试抽象工厂模式
     * */
    public void testAbstractFactory(){
        AbstractFactory luxuryCarFactory = new LuxuryCarFactory();  //高端汽车制造工厂
        Engine luxuryEngine = luxuryCarFactory.engineBuilder();   //生产高端发动机
        luxuryEngine.run();
    }

}
