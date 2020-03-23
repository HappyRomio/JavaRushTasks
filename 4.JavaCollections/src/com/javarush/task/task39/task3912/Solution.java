package com.javarush.task.task39.task3912;

/*
Максимальная площадь
*/


import java.util.Arrays;

public class Solution {

    public static int[][] rectx = {
            {0, 0, 0, 0},
            {0, 1, 1, 1},
            {0, 1, 1, 1},
            {0, 1, 1, 1}

    };

    public static void main(String[] args) {
        System.out.print(maxSquare(rectx));
    }

    public static int maxSquare(int[][] matrix) {
        int max =0;
        int[][] peocessed = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j]==1){
                    peocessed[i+1][j+1] = Math.min(Math.min(peocessed[i][j],peocessed[i+1][j]),peocessed[i][j+1])+1;
                    max = Math.max(peocessed[i+1][j+1],max);
                }
            }
        }
        return max*max;
    }


}
