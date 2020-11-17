package com.regan.thread.com.regan.thread;

/**
 *@className: volatileTest
 *@description:
 *@author: weida.shi
 *@date: 2020/4/27 23:06
 *@version: V1.0
 **/

public class VolatileTest {
    // volatile 线程可见性
    // private static volatile boolean FLAG = false;
    private static boolean FLAG = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("waiting data");
                while (!FLAG) {
                    // 如果这里执行一段程序,且flag没有被volatile的修饰,不会死循环
                    // System.out.println("doing");
                }

                System.out.println("doing something success");
            }
        }).start();

        Thread.sleep(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("prepare data ....start");
                FLAG = true;
                System.out.println("prepare data ....end");
            }
        }).start();
    }
}