package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        FileInputStream fi = new FileInputStream(fileName);
        ArrayList<Integer> arr = new ArrayList<>();
        while(fi.available() > 0) {
            arr.add(fi.read());
        }
        fi.close();

      Map<Integer,Integer> map = new HashMap<>();
        int temp;
        for(Integer i : arr){
           map.put(i, Collections.frequency(arr,i));
        }

        int max = Collections.max(map.values());

        for(Map.Entry<Integer,Integer> pair : map.entrySet()){
            if(pair.getValue() == max)
            System.out.print(pair.getKey() + " ");
        }



    }
}
