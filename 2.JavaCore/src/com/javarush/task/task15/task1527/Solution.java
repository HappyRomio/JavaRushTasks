package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String url = br.readLine();
        String[] params = url.split("\\?")[1].split("&");
        ArrayList<String> withObj = new ArrayList<>();

        for(String s : params){
            if(s.substring(0,3).equals("obj")){
                withObj.add(s);
                System.out.println(s.split("=")[0]);
            } else {
                System.out.println(s.split("=")[0]);
            }

        }

        for(String s : withObj) {
            try {
                if (s.split("=")[1] != null) {
                    alert(Double.parseDouble(s.split("=")[1]));
                }

            } catch (NumberFormatException e) {
                if (s.split("=")[1] != null) {
                    alert(s.split("=")[1]);
                }
            }
        }






    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
