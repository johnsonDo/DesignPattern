package com.pattern.practice.singleton;

/**
 * Created by DEllComputer on 2018/5/6.
 * 枚举实现单例模式
 *
 * 优点:
 * 实现简单,枚举本身就是单例模式,还避免了通过反射和反序列化的漏洞
 * 缺点:
 * 没有延时加载
 */
public enum EnumSingleton {
    INSTANCE;

    //添加自己需要的操作
    public void singletonOperation(){

    }
}
