package com.javarush.task.task27.task2707;

import java.lang.annotation.Retention;

/*
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {

           Thread thread = new Thread() {
               @Override
               public void run() {
                   for(int i = 0; i < 1000; i++) {
                       synchronized (o1) {
                           synchronized (o2) {
                               System.out.println(o1 + " " + o2);
                           }
                       }
                   }
               }
           };
           thread.start();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++) {
                    solution.someMethodWithSynchronizedBlocks(o1, o2);
                }
            }
        };
        thread1.start();
        thread.sleep(1000);
        return thread.getState() == Thread.State.BLOCKED ? false : true ;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
