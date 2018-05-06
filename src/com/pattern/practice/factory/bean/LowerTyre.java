package com.pattern.practice.factory.bean;

import com.pattern.practice.factory.inter.Tyre;

/**
 * Created by DEllComputer on 2018/5/6.
 * 低端轮胎
 */
public class LowerTyre implements Tyre {
    @Override
    public void revolve() {
        System.out.println("低端轮胎------旋转磨损大");
    }
}
