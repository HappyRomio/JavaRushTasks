package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };


        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");

    }

    public static int getRectangleCount(byte[][] a) {

        byte[][] b = new byte[a.length][a.length];
        int count = 0;

        for (int i=0 ; i<a.length;i ++){
            for (int j =0; j < a.length;j ++){
                if(a[i][j] ==1){
                    if(b[i][j]==0){
                        fillRect(a,b,i,j);
                        count++;
                    }
                }
            }
        }

        for (int i=0 ; i<b.length;i ++){
            for (int j =0; j < b.length;j ++){
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
        return count;
    }

    public static void fillRect(byte[][] source, byte[][] target, int i, int j){
        byte current = 1;
        int len = 1;
        int rght = j;
        int down = i;
        while (current!=0) {
            rght++;
            if(rght<source.length){
                if(source[down][rght]==1){
                    len++;
                }else{
                    current=0;
                }
            }else {
                current=0;
            }

        }

        current=1;
        rght=j;
        down=i;
        while (current!=0 && down<source.length) {
            if(source[down][j]==1){
                for(int ind = 0; ind < len; ind++){
                    target[down][rght+ind] = 1;
                }
                down++;
            }else{
                current=0;
            }
        }


    }
}
