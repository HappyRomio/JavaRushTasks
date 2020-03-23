package com.javarush.task.task04.task0432;

/* 
Хорошего много не бывает
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String a = r.readLine();
        int b = Integer.parseInt(r.readLine());
        int i=0;
        while (i<b) {
            System.out.println(a);
            i++;
        }

    }
}
