package com.yu.javaBasic.thread;

/**
 * @ClassName MyThread
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/10/10 10:05
 */
public class MyThread extends Thread {

    private int count = 5;
    @Override
    public synchronized void run() {
        count--;
        System.out.println(this.currentThread().getName()+",count:"+count);
    }

    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        Thread t1 = new Thread(myThread, "t1");
//        Thread t2 = new Thread(myThread, "t2");
//        Thread t3 = new Thread(myThread, "t3");
//        Thread t4 = new Thread(myThread, "t4");
//        Thread t5 = new Thread(myThread, "t5");
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
        int x = 123;
        int a = x%10; //取余3
        int b = x/10; //取整12
        int c = b%10; //2
        int d = b/10; //1
        System.out.println(a*100+c*10+d);
    }
}
