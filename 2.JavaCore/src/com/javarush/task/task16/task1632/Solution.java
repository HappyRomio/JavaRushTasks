package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static{
        threads.add(new Thread(new Thread1()));
        threads.add(new Thread(new Thread2()));
        threads.add(new Thread(new Thread3()));
        threads.add(new Thread4());
        threads.add(new Thread(new Thread5()));
    }

    public static void main(String[] args) throws InterruptedException {
        threads.get(3).start();
        System.out.println(threads.get(3).isAlive());
        Thread.sleep(1000);
        System.out.println(threads.get(3).isAlive());



    }

    public static class Thread1 implements Runnable {

        @Override
        public void run() {
            while (true){

            }
        }
    }

    public static class Thread2 implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1);
                }
            }catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }


        }
    }

    public static class Thread3 implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);

                }
            }
            catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    public static class Thread4 extends Thread implements Message {
            boolean jopa = true;
        @Override
        public void run() {
                while (jopa){
                }
        }

        @Override
        public void showWarning() {
            jopa=false;
        }
    }

    public static class Thread5 implements Runnable {

        @Override
        public void run() {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = "";
            int sum = 0;
            try {
                while (!(s = reader.readLine()).equals("N")) {
                sum+=Integer.parseInt(s);
                }
                System.out.println(sum);
            } catch(Exception e ){

            }

        }
    }
}