package test.util.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
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
