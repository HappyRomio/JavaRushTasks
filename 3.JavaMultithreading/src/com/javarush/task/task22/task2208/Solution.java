package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();


        map.put("age",null);

        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, String > entry : params.entrySet()){
            if(entry.getValue()!=null){
                sb.append(entry.getKey());
                sb.append(" = ");
                sb.append("'");
                sb.append(entry.getValue());
                sb.append("'");
                sb.append(" and ");
            }
        }
        if(sb.length()!=0) {
            sb.replace(sb.length() - 5, sb.length(), "");
        }
        return sb.toString();
    }
}
