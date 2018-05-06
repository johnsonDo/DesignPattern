package com.pattern.practice.factory.bean;

import com.pattern.practice.factory.inter.Tyre;

/**
 * Created by DEllComputer on 2018/5/6.
 * 高端轮胎
 */
public class LuxuryTyre implements Tyre {

    @Override
    public void revolve() {
        System.out.println("高端轮胎------旋转不磨损");
    }
}
