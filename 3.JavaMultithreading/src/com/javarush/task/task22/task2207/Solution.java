package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        br = new BufferedReader(new FileReader(fileName));
        List<String> ls = new ArrayList<>();
        while (br.ready()){
            for(String s : br.readLine().split(" ")){
                ls.add(s);
            }
        }
        br.close();
        for(int i = 0; i < ls.size(); i ++){
            StringBuilder sb = new StringBuilder(ls.get(i));
            sb.reverse();
            for (int j = i +1; j < ls.size(); j++ ){
                if(ls.get(j).equals(sb.toString())){
                    String first = ls.get(i);
                    String second = sb.toString();
                    if(!result.contains(new Pair(first,second))&&!result.contains(new Pair(second,first))){
                        result.add(new Pair(first,second));
                    }
                }
            }
        }



        for(Pair p : result){
            System.out.println(p);
        }



    }

    public static class Pair {
        String first;
        String second;
        public Pair(){
            first = "";
            second = "";
        }
        public Pair(String s1, String s2){
            first = s1;
            second = s2;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
