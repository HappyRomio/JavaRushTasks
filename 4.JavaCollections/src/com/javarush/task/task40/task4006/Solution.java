package com.javarush.task.task40.task4006;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        try {

            Socket socket = new Socket(url.getHost(),80);

            PrintWriter wtr = new PrintWriter(socket.getOutputStream());
            wtr.println("GET " + url.getFile() + " HTTP/1.1");
            wtr.println("Host: " + url.getHost());
            wtr.println("");
            wtr.flush();
            BufferedReader bufRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String outStr;
            while((outStr = bufRead.readLine()) != null){
                System.out.println(outStr);
            }

            bufRead.close();
            wtr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}