package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    public static Hippodrome game;
    private List<Horse> horses;

    public Hippodrome( List<Horse> h){
        horses = h;
    }

    public List<Horse> getHorses() {
        return horses;
    }



    public void run() throws InterruptedException {

        for(int i = 1; i <= 100; i ++){
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void move(){
        for(Horse h : horses){
            h.move();
        }
    }

    public void print(){
        for(Horse h : horses){
            h.print();
        }
        for(int i = 0 ; i < 10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner() {
            double max = 0;
            Horse winner =null;
        for(Horse h : horses){
            if(h.getDistance() > max){
                max = h.getDistance();
                winner=h;
            }
        }

        return winner;
    }
    public void printWinner(){
        System.out.print("Winner is " + getWinner().getName()+"!");
    }



    public static void main (String... args) throws InterruptedException {

        game = new Hippodrome(new ArrayList<>());
        Horse h1 = new Horse("Rocket",3,0);
        Horse h2 = new Horse("Lucky",3,0);
        Horse h3 = new Horse("Lightning",3,0);

        game.getHorses().add(h1);
        game.getHorses().add(h2);
        game.getHorses().add(h3);

        game.run();
        game.printWinner();

    }
}
