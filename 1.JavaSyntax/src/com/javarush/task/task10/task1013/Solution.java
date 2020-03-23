package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private String surname;
        private String birthday;
        private int age;
        private boolean sex;
        private ArrayList<Human> children;

        public Human(){
            name = "Temp";
            surname = "Temp";
            birthday = "Always Today";
            age = 0;
            sex = false;
            children = null;
        }

        public Human(Human h){
            name = h.name;
            surname = h.surname;
            birthday = h.birthday;
            age = h.age;
            sex = h.sex;
            children = h.children;
        }

        public Human(String name, String surname, String birthday, int age, boolean sex, ArrayList<Human> children) {
            this.name = name;
            this.surname = surname;
            this.birthday = birthday;
            this.age = age;
            this.sex = sex;
            this.children = children;
        }
        public Human(String name, String surname, String birthday, int age, boolean sex) {
            this.name = name;
            this.surname = surname;
            this.birthday = birthday;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, String surname, String birthday, int age) {
            this.name = name;
            this.surname = surname;
            this.birthday = birthday;
            this.age = age;

        }

        public Human(String name, String surname, String birthday) {
            this.name = name;
            this.surname = surname;
            this.birthday = birthday;

        }
        public Human(String name, String surname) {
            this.name = name;
            this.surname = surname;

        }

        public Human(String name) {
            this.name = name;

        }

        public Human(String name, String surname, String birthday, int age, ArrayList<Human> children) {
            this.name = name;
            this.surname = surname;
            this.birthday = birthday;
            this.age = age;
            this.children = children;
        }

        public Human(String name, String surname, ArrayList<Human> children) {
            this.name = name;
            this.surname = surname;
            this.children = children;
        }

    }
}
