package com.javarush.task.task04.task0443;

/* 
Как назвали, так назвали
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String name = r.readLine();


        int yy = Integer.parseInt(r.readLine());
        int mm = Integer.parseInt(r.readLine());
        int dd = Integer.parseInt(r.readLine());

        System.out.println("Меня зовут " + name + ".");
        System.out.println("Я родился " + dd + "."+ mm + "."+ yy);

    }
}
