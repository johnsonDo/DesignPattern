package com.pattern.practice.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by DEllComputer on 2018/5/4.
 * 懒汉式单例模式
 *
 * 为了解决饿汉式单例模式不能实现的懒加载造成资源浪费的情况
 *
 * 优点:可以延时加载,资源利用率高了,线程安全
 * 缺点:调用效率不高,在多线程访问时,会出现等待的情况;
 */
public class LazySingleton implements Serializable{
    private static LazySingleton lazySingleton;

    /**
     * 私有构造器
     * */
    private LazySingleton() {
        /**
         * 为了防止反射破解
         * */
        if(lazySingleton != null){
            //表明已经存在实例化的对象了,不能再实例化了
            throw new RuntimeException("实例对象已经存在");
        }
    }

    /**
     * 懒汉式单例:解决了饿汉式单例不能懒加载的问题,提高了资源利用率;
     * 为什么要使用synchronized?
     * 在单线程程序中不使用完全没问题.但是,在多线程程序中,多个线程来访问getInstance方法,
     * 当一个线程访问到if判断还没执行new对象语句时,换另一个线程来执行了,此时这个线程执行if判断的时候,lazySingleton对象依然
     * 为null,所以依然会实例化出不同的对象,所以需要加上synchronized来保证线程安全
     * */
    public static synchronized LazySingleton getInstance(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }

        return lazySingleton;
    }

    /**
     * 为了防止序列化反序列化漏洞
     * 反序列化时,如果定义了readResolve()方法,则直接返回此方法指定的对象,而不需要单独再创建新对象
     * */
    private Object readResolve() throws ObjectStreamException{
        return lazySingleton;
    }
}
