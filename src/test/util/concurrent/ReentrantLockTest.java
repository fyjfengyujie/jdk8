package test.util.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + "0");

        ReentrantLock lock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("获取锁");
                    System.out.println(Thread.currentThread().getName() + "1");
                    Thread.sleep(1000000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("获取锁");
                    System.out.println(Thread.currentThread().getName() + "2");
                    Thread.sleep(1000000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("获取锁");
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
