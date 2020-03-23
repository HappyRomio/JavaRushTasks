package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {

    private Thread thread;
    private State lastState;
    LoggingStateThread(Thread thread){
        this.thread = thread;
        lastState = null;
    }

    @Override
    public void run(){
        while(thread.getState() != State.TERMINATED) {
            if(lastState != thread.getState()) {
                System.out.println(thread.getState());
                lastState = thread.getState();
            }
        }
            this.interrupt();
    }
}
