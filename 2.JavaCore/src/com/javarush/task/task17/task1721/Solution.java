package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));

        String s;
        while((s =reader1.readLine()) != null){
            allLines.add(s);
        }

        reader1.close();
        BufferedReader reader2 = new BufferedReader(new FileReader(fileName2));

        while((s =reader2.readLine()) != null){
            forRemoveLines.add(s);
        }
        reader2.close();

            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void joinData() throws IOException {

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
