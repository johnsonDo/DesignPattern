package com.pattern.practice.factory;

import com.pattern.practice.factory.bean.Audi;
import com.pattern.practice.factory.bean.BMW;
import com.pattern.practice.factory.inter.Car;


/**
 * Created by DEllComputer on 2018/5/6.
 * 简单工厂模式--用来实例化不同类型的Car
 *
 * 简单工厂模式有个问题:
 * 要新增不同类型的车型的时候,需要修改已有代码,不符合面向对象的开闭原则,因此出现了工厂方法模式
 *
 */
public class EasyCarFactory {

    public static Car createCar(String type){
        Car car = null;

        if("奥迪".equals(type)){
            return new Audi();
        }else if("宝马".equals(type)){
            return new BMW();
        }
        return car;
    }
}
