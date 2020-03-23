package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<Human> chd1 = new ArrayList<>();
        ArrayList<Human> chd2 = new ArrayList<>();
        ArrayList<Human> chd3 = new ArrayList<>();
        ArrayList<Human> result = new ArrayList<>();

        Human h1 = new Human("name", true, 10,new ArrayList<>());
        Human h2 = new Human("name", true, 10,new ArrayList<>());
        Human h3 = new Human("name", false, 10,new ArrayList<>());
        chd1.add(h1);
        chd1.add(h2);
        chd1.add(h3);
        Human h4 = new Human("name", false, 30,chd1);
        Human h5 = new Human("name", true, 30,chd1);
        chd2.add(h4);
        chd3.add(h5);
        Human h6 = new Human("name", true, 100,chd2);
        Human h7 = new Human("name", false, 100,chd2);
        Human h8 = new Human("name", true, 100,chd3);
        Human h9 = new Human("name", false, 100,chd3);

        result.add(h9);
        result.add(h8);
        result.add(h7);
        result.add(h6);
        result.add(h5);
        result.add(h4);
        result.add(h3);
        result.add(h2);
        result.add(h1);

        for(Human h : result) {
            System.out.println(h.toString());
        }



    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
