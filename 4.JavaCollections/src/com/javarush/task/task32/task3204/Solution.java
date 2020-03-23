package com.javarush.task.task32.task3204;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
       System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        Random r = new Random();
        char[] b = new char[8];
        boolean num = false, alpha = false, alphaUp = false;
        int mode = 0;
        ByteArrayOutputStream br = new ByteArrayOutputStream();
        while(!(alpha&&alphaUp&&num)) {
            for (int i = 0; i < 8; i++) {
                mode = r.nextInt(3);
                switch (mode) {
                    case 0:
                        br.write((char) (r.nextInt(26) + 'a'));
                        alpha = true;
                        break;
                    case 1:
                        br.write((char) (r.nextInt(26) + 'A'));
                        alphaUp = true;
                        break;
                    case 2:
                        br.write(48 + r.nextInt(10));
                        num = true;
                        break;
                }
            }
            if (!(alpha && alphaUp && num)) {
                alpha = false;
                alphaUp = false;
                num = false;
                br.reset();
            }
        }

        return br;
    }
}