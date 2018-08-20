package com.sagelu.javaproblems;

/**
 * 类名: Deadlock
 * 此类用途: ---
 *
 * @Date: 2018-08-18 11:10
 * @FileName: com.sagelu.javaproblems.Deadlock.java
 */
public class Deadlock {

    private String objID;

    public Deadlock(String id) {
        objID = id;
    }

    public synchronized void checkOther(Deadlock other) {
        print("entering checkOther()");
        try { Thread.sleep(50000); }
        catch ( InterruptedException x ) { }
        print("in checkOther() - about to " + "invoke 'other.action()'");
        //调用other对象的action方法，由于该方法是同步方法，因此会试图获取other对象的对象锁
        other.action();
        print("leaving checkOther()");
    }

    public synchronized void action() {
        print("entering action()");
        try { Thread.sleep(10000); }
        catch ( InterruptedException x ) { }
        print("leaving action()");
    }

    public void print(String msg) {
        threadPrint("objID=" + objID + " - " + msg);
    }

    public static void threadPrint(String msg) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": " + msg);
    }



}