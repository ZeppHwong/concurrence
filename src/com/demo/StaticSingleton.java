package com.demo;

/**
 * 单例模式 使用内部类初始化懒加载
 * getInstance 没有锁
 */
public class StaticSingleton {
    private StaticSingleton(){
        System.out.println("StaticSingleton.StaticSingleton");
    }

    private static class StaticHolder{
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return StaticHolder.instance;
    }
}
