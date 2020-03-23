package com.javarush.task.task28.task2805;


public class MyThread extends Thread {
    public static int priority = 1;
    public MyThread() {
        if(priority == MAX_PRIORITY) {
            setPriority(priority);
            priority =1;
        }else {
            setPriority(priority);
            priority++;
        }
    }

    public MyThread(Runnable target) {
        super(target);
        if(priority == MAX_PRIORITY) {
            setPriority(priority);
            priority =1;
        }else {
            setPriority(priority);
            priority++;
        }
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if(priority >= group.getMaxPriority()) {
            if(priority==MAX_PRIORITY) {
                priority = 1;
            } else {
                priority++;
            }
            setPriority(group.getMaxPriority());
        }else {
            setPriority(priority);
            priority++;
        }

    }

    public MyThread(String name) {
        super(name);
        if(priority == MAX_PRIORITY) {
            setPriority(priority);
            priority =1;
        }else {
            setPriority(priority);
            priority++;
        }
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if(priority >= group.getMaxPriority()) {
            if(priority==MAX_PRIORITY) {
                priority = 1;
            } else {
                priority++;
            }
            setPriority(group.getMaxPriority());
        }else {
            setPriority(priority);
            priority++;
        }
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if(priority == MAX_PRIORITY) {
            setPriority(priority);
            priority =1;
        }else {
            setPriority(priority);
            priority++;
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if(priority >= group.getMaxPriority()) {
            if(priority==MAX_PRIORITY) {
                priority = 1;
            } else {
                priority++;
            }
            setPriority(group.getMaxPriority());
        }else {
            setPriority(priority);
            priority++;
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if(priority >= group.getMaxPriority()) {
            if(priority==MAX_PRIORITY) {
                priority = 1;
            } else {
                priority++;
            }
            setPriority(group.getMaxPriority());
        }else {
            setPriority(priority);
            priority++;
        }
    }

}
