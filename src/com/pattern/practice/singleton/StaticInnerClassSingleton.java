package com.pattern.practice.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by DEllComputer on 2018/5/6.
 * 单例模式-静态内部类实现方式
 *
 * 优点:
 * 1:外部类没有static属性,不会像饿汉式那样立即加载对象
 * 2:只有需要用到实例的时候才会加载静态内部类,加载类是线程安全的,instance是static final类型,保证了内存中只有这样一个实例存在,而且只能被赋值一次,从而保证了线程安全
 * 3:兼备了并发高效调用和延迟加载的优势,就解决了懒汉式并发效率不高的问题
 */
public class StaticInnerClassSingleton implements Serializable{

    /**
     * 内部类
     * */
    private static class SingletonClassInstance{
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    /**
     * 私有构造器
     * */
    private StaticInnerClassSingleton() {

        /**
         * 为了防止反射破解
         * */
        if(SingletonClassInstance.instance != null){
            //表明已经存在实例化的对象了,不能再实例化了
            throw new RuntimeException("实例对象已经存在");
        }

    }

    public static StaticInnerClassSingleton getInstance(){
        return SingletonClassInstance.instance;
    }

    /**
     * 为了防止序列化反序列化漏洞
     * 反序列化时,如果定义了readResolve()方法,则直接返回此方法指定的对象,而不需要单独再创建新对象
     * */
    private Object readResolve() throws ObjectStreamException {
        return SingletonClassInstance.instance;
    }
}
