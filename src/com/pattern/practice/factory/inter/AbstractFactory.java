package com.pattern.practice.factory.inter;

/**
 * Created by DEllComputer on 2018/5/6.
 *
 * 抽象工厂模式
 *
 * 抽象工厂模式是用来生产不同产品族的全部产品
 *
 * 比如车由发动机,座椅,轮胎组成
 *
 *
 */
public interface AbstractFactory {

    Engine engineBuilder();   //发动机制造
    Tyre tyreBuilder();       //轮胎制造
}
