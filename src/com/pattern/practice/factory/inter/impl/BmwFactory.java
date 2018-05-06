package com.pattern.practice.factory.inter.impl;

import com.pattern.practice.factory.bean.BMW;
import com.pattern.practice.factory.inter.Car;
import com.pattern.practice.factory.inter.FactoryFunction;

/**
 * Created by DEllComputer on 2018/5/6.
 * 宝马工厂,专门制造宝马
 */
public class BmwFactory implements FactoryFunction{

    @Override
    public Car createCar() {
        return new BMW();
    }
}
