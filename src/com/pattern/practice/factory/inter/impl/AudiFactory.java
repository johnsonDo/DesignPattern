package com.pattern.practice.factory.inter.impl;

import com.pattern.practice.factory.inter.Car;
import com.pattern.practice.factory.inter.FactoryFunction;
import com.pattern.practice.factory.bean.Audi;

/**
 * Created by DEllComputer on 2018/5/6.
 * 奥迪工厂,专门制造奥迪
 */
public class AudiFactory implements FactoryFunction {

    @Override
    public Car createCar() {
        return new Audi();
    }
}
