package com.pattern.practice.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by DEllComputer on 2018/5/4.
 * 饿汉式单例   (线程安全,效率高,但是不能延时加载)
 *
 * 为什么叫饿汉式:因为一加载这个类,就会实例化hungerSingleton对象,不管你是否需要使用这个类
 */
public class HungerSingleton implements Serializable{

    private static HungerSingleton hungerSingleton = new HungerSingleton();

    /**
     * 私有构造器
     * */
    private HungerSingleton() {
        /**
         * 为了防止反射破解
         * */
        if(hungerSingleton != null){
            //表明已经存在实例化的对象了,不能再实例化了
            throw new RuntimeException("实例对象已经存在");
        }
    }

    /**
     * 对外提供获取对象的方法
     * */
    public static HungerSingleton getInstance(){
        return hungerSingleton;
    }

    /**
     * 为了防止序列化反序列化漏洞
     * 反序列化时,如果定义了readResolve()方法,则直接返回此方法指定的对象,而不需要单独再创建新对象
     * */
    private Object readResolve() throws ObjectStreamException {
        return hungerSingleton;
    }
}
