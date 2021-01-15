package test.util.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + "0");

        ReentrantLock lock = new ReentrantLock();

        Condition condition = lock.newCondition();

        Condition conditionB = lock.newCondition();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("获取锁");
                    System.out.println("等待A");
                    condition.await();
                    System.out.println("唤醒A");
//                    Thread.sleep(1000000000);
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
                    System.out.println("等待B");
                    condition.await();
                    System.out.println("唤醒B");
//                    Thread.sleep(1000000000);
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
                    System.out.println("等待C");
                    condition.await();
                    System.out.println("唤醒C");
//                    Thread.sleep(1000000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    lock.lock();
//                    System.out.println("获取锁");
//                    System.out.println(Thread.currentThread().getName() + "2");
//                    Thread.sleep(1000000000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
//            }
//        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    lock.lock();
//                    System.out.println("获取锁");
//                } finally {
//                    lock.unlock();
//                }
//            }
//        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("获取锁");
//                    try {
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    condition.signal();
                    System.out.println("唤醒一次");
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    condition.signal();
                    System.out.println("唤醒二次");

                    condition.signal();
                    System.out.println("唤醒三次");
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
