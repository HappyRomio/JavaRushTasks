package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CanFly result;

    public static void reset() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String param = br.readLine();

        if(param.equals("helicopter")) {
            result = new Helicopter();
        } else if(param.equals("plane")) {
            int passang = Integer.parseInt(br.readLine());
            result = new Plane(passang);
        }

        br.close();

    }
}
