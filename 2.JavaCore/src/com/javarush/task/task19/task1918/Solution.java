package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        StringBuilder sb = new StringBuilder();
        BufferedReader fr = new BufferedReader(new FileReader(fileName));
        while(fr.ready()){
            sb.append(fr.readLine());
            sb.append('\r');
            sb.append('\n');
        }
        fr.close();

        int openedStart = sb.indexOf("<"+args[0]);
        int closedStart = sb.indexOf("</"+args[0]+">");
        int curren=openedStart;
        int lvl = 0;
        while(openedStart!=-1) {
            while (curren != -1) {
                curren++;
                curren = sb.indexOf("<" + args[0], curren);
                if (curren > openedStart && curren < closedStart) {
                    lvl++;
                }
            }
            for (int i = 0; i < lvl; i++) {
                closedStart++;
                closedStart = sb.indexOf("</" + args[0] + ">", closedStart);
            }
            int temp = closedStart;
            for (int i = 0; i <= lvl; i++) {
                openedStart = sb.indexOf("<" + args[0], openedStart);
                closedStart = sb.lastIndexOf("</" + args[0] + ">", closedStart);
                System.out.println(sb.substring(openedStart, closedStart + args[0].length() + 3));
                openedStart++;
                closedStart--;
            }
            openedStart =sb.indexOf("<" + args[0], temp+1);
            closedStart=sb.indexOf("</"+args[0]+">", temp+1);
            curren=openedStart;
            lvl=0;
        }

    }




}
