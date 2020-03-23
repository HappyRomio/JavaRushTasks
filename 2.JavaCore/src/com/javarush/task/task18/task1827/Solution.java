package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        if (args.length != 0) {
            char[] id = new char[8];
            char[] productName = new char[30];
            char[] price = new char[8];
            char[] quantity = new char[4];

            BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            ArrayList<Integer> arr = new ArrayList<>();
            String s;
            while ((s = fr.readLine()) != null) {
                arr.add(Integer.parseInt(s.substring(0, 8).trim()));
            }


            if(arr.size()>0){
                String nextId = String.valueOf(Collections.max(arr)+1);
            for (int i = 0; i < id.length; i++) {
                if (i < nextId.length()) {
                    id[i] = nextId.charAt(i);
                } else {
                    id[i] = ' ';
                }
            }
        } else {
            id = new char[]{'1', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        }

            fr.close();

            for(int i =0; i < productName.length; i++){
                if(i < args[1].length()){
                    productName[i] = args[1].charAt(i);
                } else {
                    productName[i]  = ' ';
                }
            }

            for(int i =0; i < price.length; i++){
                if(i < args[2].length()){
                    price[i] = args[2].charAt(i);
                } else {
                   price[i]  = ' ';
                }
            }

            for(int i =0; i < quantity.length; i++){
                if(i < args[3].length()){
                    quantity[i] = args[3].charAt(i);
                }else {
                    quantity[i]  = ' ';
                }
            }

        BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName,true)));


            String result = String.valueOf(id) + String.valueOf(productName) + String.valueOf(price) +String.valueOf(quantity);
            if(Integer.parseInt(String.valueOf(id).trim())!=1) {
                fw.newLine();
            }
            fw.write(result);
            fw.flush();
            fw.close();

       }
    }
}
