package com.pattern.practice.factory.bean;

import com.pattern.practice.factory.inter.Car;

/**
 * Created by DEllComputer on 2018/5/6.
 */
public class Audi implements Car {
    @Override
    public void run() {
        System.out.println("奥迪在跑!!!!!!");
    }
}
