package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {

    public static void main(String[] args) {
        Man oleg = new Man("Oleg", 24, "Rostov-on-Don");
        Man misha = new Man("Misha", 25, "Rostov-on-Don");
        Woman inga = new Woman("Inga", 19 , "Moscow");
        Woman nina = new Woman("Nana", 84 , "Moscow");
        System.out.println(oleg);
        System.out.println(misha);
        System.out.println(inga);
        System.out.println(nina);
    }

    public static class Man {
        String name;
        int age;
        String address;

        public Man (String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String toString() {
            return name + " " + age + " " + address;
        }

    }

    public static class Woman {
        String name;
        int age;
        String address;

        public Woman (String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String toString() {
            return name + " " + age + " " + address;
        }

    }
}
