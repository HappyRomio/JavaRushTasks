package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Human dedMom = new Human("Макар петрович", true, 84);
        Human dedDad = new Human("Евпатий Коловратий", true, 150);

        Human grannyMom = new Human("Анфиса Семеновна", false, 78);
        Human grannyDad = new Human("Галина Никитична", false , 91);

        Human mom = new Human("Мама Эльвира", false, 34, dedMom,grannyMom);
        Human dad = new Human("Батя Витя",true, 36, dedDad,grannyDad);

        Human child1 = new Human("Вово1", true, 12, dad, mom);
        Human child2 = new Human("Вово2", true, 12, dad, mom);
        Human child3 = new Human("Вово3", true, 12, dad, mom);

        ArrayList<Human> ls = new ArrayList<>();
        ls.add(dedDad);
        ls.add(dedMom);
        ls.add(grannyMom);
        ls.add(grannyDad);
        ls.add(dad);
        ls.add(mom);
        ls.add(child1);
        ls.add(child2);
        ls.add(child3);

        for(Human h : ls) {
            System.out.println(h.toString());
        }

    }

    public static class Human {

        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}