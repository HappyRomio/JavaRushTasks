package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        if(args[0].equals("-c")) {
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


                if (arr.size() > 0) {
                    String nextId = String.valueOf(Collections.max(arr) + 1);
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

                for (int i = 0; i < productName.length; i++) {
                    if (i < args[1].length()) {
                        productName[i] = args[1].charAt(i);
                    } else {
                        productName[i] = ' ';
                    }
                }

                for (int i = 0; i < price.length; i++) {
                    if (i < args[2].length()) {
                        price[i] = args[2].charAt(i);
                    } else {
                        price[i] = ' ';
                    }
                }

                for (int i = 0; i < quantity.length; i++) {
                    if (i < args[3].length()) {
                        quantity[i] = args[3].charAt(i);
                    } else {
                        quantity[i] = ' ';
                    }
                }

                BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));


                String result = String.valueOf(id) + String.valueOf(productName) + String.valueOf(price) + String.valueOf(quantity);
                if (Integer.parseInt(String.valueOf(id).trim()) != 1) {
                    fw.newLine();
                }
                fw.write(result);
                fw.flush();
                fw.close();

            }
        }

        if(args[0].equals("-u")){
            BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            ArrayList<String> arr = new ArrayList<>();

            while(fr.ready()){
                arr.add(fr.readLine());
            }
            fr.close();
            for(int j = 0; j < arr.size();j++){
               if(arr.get(j).substring(0,8).trim().equals(args[1])){
                   char[] id = new char[8];
                   char[] productName = new char[30];
                   char[] price = new char[8];
                   char[] quantity = new char[4];

                   for (int i = 0; i < id.length; i++) {
                       if (i < args[1].length()) {
                           id[i] = args[1].charAt(i);
                       } else {
                           id[i] = ' ';
                       }
                   }

                   for (int i = 0; i < productName.length; i++) {
                       if (i < args[2].length()) {
                           productName[i] = args[2].charAt(i);
                       } else {
                           productName[i] = ' ';
                       }
                   }

                   for (int i = 0; i < price.length; i++) {
                       if (i < args[3].length()) {
                           price[i] = args[3].charAt(i);
                       } else {
                           price[i] = ' ';
                       }
                   }

                   for (int i = 0; i < quantity.length; i++) {
                       if (i < args[4].length()) {
                           quantity[i] = args[4].charAt(i);
                       } else {
                           quantity[i] = ' ';
                       }
                   }
                   String result = String.valueOf(id) + String.valueOf(productName) + String.valueOf(price) + String.valueOf(quantity);
                   arr.set(j,result);
                   BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
                   for(String s : arr){
                       fw.write(s);
                       fw.newLine();
                   }
                   fw.close();
                   return;
               }
            }
        }

        if(args[0].equals("-d")){
            BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            ArrayList<String> arr = new ArrayList<>();

            while(fr.ready()){
                arr.add(fr.readLine());
            }
            fr.close();
            for(int j = 0; j < arr.size();j++){
                System.out.println(arr.get(j).substring(0,8));
                System.out.println(args[1]);
                if(arr.get(j).substring(0,8).trim().equals(args[1])){
                    arr.remove(j);
                    BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
                    for(String s : arr){
                        fw.write(s);
                        fw.newLine();
                    }
                    fw.close();
                    return;
                }
            }
        }

    }
}
