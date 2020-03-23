package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        String s = " ";

        try { boolean flag = true;
        while(true) {

                int id = Integer.parseInt(reader.readLine());
                String name = reader.readLine();
                if(name.equals("")){
                    map.put("", id);
                    break;
                } else {
                    map.put(name, id);
                }


        }
        }catch(Exception ex){
        }

        for (Map.Entry<String, Integer> e : map.entrySet()){
            System.out.println(e.getValue() + " " + e.getKey());
        }




    }
}
