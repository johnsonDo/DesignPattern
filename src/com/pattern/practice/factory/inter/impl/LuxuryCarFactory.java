package com.pattern.practice.factory.inter.impl;

import com.pattern.practice.factory.bean.LuxuryEngine;
import com.pattern.practice.factory.bean.LuxuryTyre;
import com.pattern.practice.factory.inter.AbstractFactory;
import com.pattern.practice.factory.inter.Engine;
import com.pattern.practice.factory.inter.Tyre;

/**
 * Created by DEllComputer on 2018/5/6.
 */
public class LuxuryCarFactory implements AbstractFactory {

    @Override
    public Engine engineBuilder() {
        return new LuxuryEngine();      //这里还可以用工厂模式来创建实例,简单起见就直接实例
    }

    @Override
    public Tyre tyreBuilder() {
        return new LuxuryTyre();
    }
}
