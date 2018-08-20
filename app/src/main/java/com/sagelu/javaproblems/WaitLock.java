package com.sagelu.javaproblems;

/**
 * 类名: WaitLock
 * 此类用途: ---
 *
 * @Date: 2018-08-18 11:27
 * @FileName: com.sagelu.javaproblems.WaitLock.java
 */
public class WaitLock {
    public static void main(String[] args) {
        final Object a = new Object();
        final Object b = new Object();
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                synchronized (a) {
                    try {
                        System.out.println("now i in threadA-locka");
                        Thread.sleep(1000l);
                        synchronized (b) {
                            System.out.println("now i in threadA-lockb");
                        }
                    } catch (Exception e) {
                        // ignore
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            public void run() {
                synchronized (b) {
                    try {
                        System.out.println("now i in threadB-lockb");
                        Thread.sleep(1000l);
                        synchronized (a) {
                            System.out.println("now i in threadB-locka");
                        }
                    } catch (Exception e) {
                        // ignore
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }

}
