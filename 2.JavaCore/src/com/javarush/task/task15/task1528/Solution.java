package com.javarush.task.task15.task1528;

/* 
ООП. Hrivna — тоже деньги
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Hrivna().getAmount());
    }

    public static abstract class Money {
        abstract Money getMoney();

        abstract Object getAmount();
    }

    //add your code below - добавь код ниже
    public static class Hrivna extends Money {
        private double amount = 123d;

        public Hrivna getMoney() {
            return this;
        }

        @Override
       public Object getAmount() {
                return this.amount;
        }
    }
}
