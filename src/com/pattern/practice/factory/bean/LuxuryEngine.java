package com.pattern.practice.factory.bean;

import com.pattern.practice.factory.inter.Engine;

/**
 * Created by DEllComputer on 2018/5/6.
 *
 * 高端发动机
 */
public class LuxuryEngine implements Engine{

    @Override
    public void run() {
        System.out.println("高端发动机-----转速更快");
    }
}
