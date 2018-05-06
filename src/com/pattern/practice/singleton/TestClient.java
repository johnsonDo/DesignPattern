package com.pattern.practice.singleton;


import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by DEllComputer on 2018/5/4.
 */
public class TestClient {

    public static void main(String[] args) throws Exception {
//饿汉式测试       new TestClient().testHungerSingleton();
//懒汉式测试        new TestClient().testLazySingleton();
//内部类实现方式测试  new TestClient().testInnerClassSingleton();
//利用反射破解除了枚举实现方式的单例模式    new TestClient().crackSingletonByReflex();

//利用序列化反序列化破解除了枚举实现方式的单例模式        new TestClient().crackSingletonBySerialize(LazySingleton.getInstance());
    }

    /**
     * 测试饿汉式单例模式
     */
    public void testHungerSingleton() {
        HungerSingleton hungerSingleton1 = HungerSingleton.getInstance();
        HungerSingleton hungerSingleton2 = HungerSingleton.getInstance();

        System.out.println(hungerSingleton1);
        System.out.println(hungerSingleton2);
        //测试发现输出值一样,是同一个对象
    }

    /**
     * 测试懒汉式单例模式
     * <p>
     * 在测试懒汉式单例模式的时候,我们可以在LaztSingleton.java的getInstance()方法去掉synchronized关键字
     * 然后在实例化对象之前,让线程等待几秒钟,然后再用多线程去测试,我们可以发现这样就会实例化出不同的对象,所以懒汉式单例模式需要加上synchronized关键字,
     * 以保证线程安全
     */
    public void testLazySingleton() {

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new TestLazySingletonRunnable("线程" + i));
            thread.start();
        }
    }

    /**
     * 测试静态内部类实现的单例模式
     */
    public void testInnerClassSingleton() {
        for (int i = 0; i < 10; i++) {
            System.out.println(StaticInnerClassSingleton.getInstance());

        }
    }

    /**
     * 通过反射来破解上述单例模式(除了枚举模式的单例不能破解,因为枚举是基于jvm实现的,是天然的单例)
     */
    public void crackSingletonByeflex() {

        Class<StaticInnerClassSingleton> clazz = null;
        try {
            clazz = (Class<StaticInnerClassSingleton>) Class.forName("com.pattern.practice.singleton.StaticInnerClassSingleton");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Constructor<StaticInnerClassSingleton> constructor = null;
        try {
            constructor = clazz.getDeclaredConstructor(null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        constructor.setAccessible(true);  //因为单例模式的构造器是私有的

        StaticInnerClassSingleton staticInnerClassSingleton1 = null;
        StaticInnerClassSingleton staticInnerClassSingleton2 = null;
        try {
            staticInnerClassSingleton1 = constructor.newInstance();
            staticInnerClassSingleton2 = constructor.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        System.out.println(staticInnerClassSingleton1);
        System.out.println(staticInnerClassSingleton2);
    }

    /**
     * 通过序列化来破解单例
     * */
    public void crackSingletonBySerialize(LazySingleton lazySingleton) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("/Users/jiangdongcheng/GithubCode/DesignPattern/src/com/pattern/practice/singleton/a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(lazySingleton);
        oos.close();
        fos.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/jiangdongcheng/GithubCode/DesignPattern/src/com/pattern/practice/singleton/a.txt"));
        LazySingleton lazySingleton1 = (LazySingleton) ois.readObject();

        System.out.println(lazySingleton);
        System.out.println(lazySingleton1);

    }


}

class TestLazySingletonRunnable implements Runnable {
    private String threadName;

    public TestLazySingletonRunnable(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println(threadName + "----------->" + lazySingleton);
    }
}
