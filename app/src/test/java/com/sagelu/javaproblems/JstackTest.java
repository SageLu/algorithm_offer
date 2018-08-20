package com.sagelu.javaproblems;

import org.junit.Test;

/**
 * 类名: JstackTest
 * 此类用途: ---
 * Java面试必问-死锁终极篇
 *  https://juejin.im/post/5aaf6ee76fb9a028d3753534
 * @Date: 2018-08-18 10:28
 * @FileName: com.sagelu.javaproblems.JstackTest.java
 */
public class JstackTest {
    @Test
    public void addition_isCorrect() throws Exception {
        while (true) {

        }
    }
    @Test
    public void checkJPS()  {
        final Deadlock obj1 = new Deadlock("obj1");
        final Deadlock obj2 = new Deadlock("obj2");

        Runnable runA = new Runnable() {
            public void run() {
                obj1.checkOther(obj2);
            }
        };

        Thread threadA = new Thread(runA, "threadA");
        threadA.start();

        try { Thread.sleep(20000); }
        catch ( InterruptedException x ) { }

        Runnable runB = new Runnable() {
            public void run() {
                obj2.checkOther(obj1);
            }
        };

        Thread threadB = new Thread(runB, "threadB");
        threadB.start();

        try { Thread.sleep(50000); }
        catch ( InterruptedException x ) { }

        Deadlock.threadPrint("finished sleeping");

        Deadlock.threadPrint("about to interrupt() threadA");

        threadA.interrupt();

        try { Thread.sleep(10000); }
        catch ( InterruptedException x ) { }

        Deadlock.threadPrint("about to interrupt() threadB");
        threadB.interrupt();

        try { Thread.sleep(10000); }
        catch ( InterruptedException x ) { }

        Deadlock.threadPrint("did that break the deadlock?");

    }

}
