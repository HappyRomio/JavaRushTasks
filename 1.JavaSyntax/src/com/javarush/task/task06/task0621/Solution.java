package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String dedName = reader.readLine();
        Cat ded = new Cat(dedName);

        String babushkaName = reader.readLine();
        Cat babushka = new Cat(babushkaName);

        String batyaName = reader.readLine();
        Cat batya = new Cat(batyaName,ded, null);

        String mamanName = reader.readLine();
        Cat maman = new Cat(mamanName, null, babushka);

        String sonName = reader.readLine();
        Cat son = new Cat(sonName,batya, maman);

        String dochaName = reader.readLine();
        Cat docha = new Cat(dochaName,batya, maman);

        System.out.println(ded);
        System.out.println(babushka);
        System.out.println(batya);
        System.out.println(maman);
        System.out.println(son);
        System.out.println(docha);
    }

    public static class Cat {
        private String name;
        private Cat father;
        private Cat mother;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat father, Cat mother) {
            this.name = name;
            this.father = father;
            this.mother = mother;
        }

        @Override
        public String toString() {

            String result = "The cat's name is " + name;

            if(mother==null){
                result += ", no mother";
            } else {
                result += ", mother is " + mother.name ;
            }

            if (father == null) {
                result += ", no father";
            } else {
                result += ", father is " + father.name;
            }

            return result;
        }
    }

}
