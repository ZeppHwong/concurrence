package com.demo;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.locks.ReentrantLock;

public class FairLock implements Runnable {
    public static final ReentrantLock fairLock = new ReentrantLock(true);
    @Override
    public void run() {
        while (true){
            try {
                fairLock.lock();
                System.out.println("FairLock.run>>" + Thread.currentThread().getName());
            }finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args){
        FairLock lock = new FairLock();
        Thread t1 = new Thread(lock,"thread1");
        Thread t2 = new Thread(lock,"thread2");
        t1.start();
        t2.start();
    }
}
