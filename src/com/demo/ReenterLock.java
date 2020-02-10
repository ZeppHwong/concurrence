package com.demo;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLock implements Runnable {
    public final static ReentrantLock lock = new ReentrantLock();
    static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            lock.lock();
            try {
                i++;
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock lock = new ReenterLock();
        Thread t1 = new Thread(lock);
        Thread t2 = new Thread(lock);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("ReenterLock.main >>> " + i);
    }
}
