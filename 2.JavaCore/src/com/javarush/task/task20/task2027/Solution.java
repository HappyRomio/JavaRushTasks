package com.javarush.task.task20.task2027;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> list = detectAllWords(crossword, "home", "same");

        for(Word w : list){
            System.out.println(w);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> list = new ArrayList<>();
        Word wr;
        for(String word : words){
            for(int i =0; i < crossword[0].length; i++) {
                for (int j = 0; j < crossword.length; j++) {
                    if (word.charAt(0) == crossword[j][i]) {
                        wr= findWordTopBot(crossword,word,i,j);
                        if(wr!=null){
                            list.add(wr);
                        }
                        wr= findWordLeftRigth(crossword,word,i,j);
                        if(wr!=null){
                            list.add(wr);
                        }
                        wr= findWordCrossLeftToRight(crossword,word,i,j);
                        if(wr!=null){
                            list.add(wr);
                        }
                        wr= findWordCrossRightToLeft(crossword,word,i,j);
                        if(wr!=null){
                            list.add(wr);
                        }
                    }
                }
            }
        }

        return list;
    }


    public static Word findWordLeftRigth(int[][] crossword, String word, int iStrat, int jStart) {
        int startI = iStrat;
        boolean finded = true;
        for (int i = 1; i < word.length(); i++) {
            startI++;
            if (startI < crossword[0].length) {
                if (!(word.charAt(i) == (char)crossword[jStart][startI])) {
                    finded = false;
                    break;
                }
            } else {
                finded = false;
                break;
            }
        }

        if (!finded) {
            startI = iStrat;
            finded = true;
            for (int i = 1; i < word.length(); i++) {
                startI--;
                if (startI >= 0) {
                    if (!(word.charAt(i) == (char)crossword[jStart][startI])) {
                        finded = false;
                        break;
                    }
                } else {
                    finded = false;
                    break;
                }
            }
        }
        if(finded){
            Word w = new Word(word);
            w.setStartPoint(iStrat, jStart);
            w.setEndPoint(startI,jStart);
            return w;
        } else {
            return null;
        }
    }


    public static Word findWordTopBot(int[][] crossword, String word, int iStrat, int jStart) {
        int startJ = jStart;
        boolean finded = true;
        for (int i = 1; i < word.length(); i++) {
            startJ++;
            if (startJ < crossword.length) {
                if (!(word.charAt(i) == (char)crossword[startJ][iStrat])) {
                    finded = false;
                    break;
                }
            } else {
                finded = false;
                break;
            }
        }

        if (!finded) {
            startJ = jStart;
            finded = true;
            for (int i = 1; i < word.length(); i++) {
                startJ--;
                if (startJ >= 0) {
                    if (!(word.charAt(i) == crossword[startJ][iStrat])) {
                        finded = false;
                        break;
                    }
                } else {
                    finded = false;
                    break;
                }
            }
        }
        if(finded){
            Word w = new Word(word);
            w.setStartPoint(iStrat, jStart);
            w.setEndPoint(iStrat,startJ);
            return w;
        } else {
            return null;
        }
    }


    public static Word findWordCrossLeftToRight(int[][] crossword, String word, int iStrat, int jStart) {
        int startJ = jStart, startI=iStrat;
        boolean finded = true;
        for (int i = 1; i < word.length(); i++) {
            startJ++;
            startI++;
            if (startJ < crossword.length&&startI <crossword[0].length) {
                if (!(word.charAt(i) == (char)crossword[startJ][startI])) {
                    finded = false;
                    break;
                }
            } else {
                finded = false;
                break;
            }
        }

        if (!finded) {
            startJ = jStart;
            startI = iStrat;
            finded = true;
            for (int i = 1; i < word.length(); i++) {
                startJ--;
                startI--;
                if (startJ >= 0 && startI >=0) {
                    if (!(word.charAt(i) == crossword[startJ][startI])) {
                        finded = false;
                        break;
                    }
                } else {
                    finded = false;
                    break;
                }
            }
        }
        if(finded){
            Word w = new Word(word);
            w.setStartPoint(iStrat, jStart);
            w.setEndPoint(startI,startJ);
            return w;
        } else {
            return null;
        }
    }

    public static Word findWordCrossRightToLeft(int[][] crossword, String word, int iStrat, int jStart) {
        int startJ = jStart, startI=iStrat;
        boolean finded = true;
        for (int i = 1; i < word.length(); i++) {
            startJ--;
            startI++;
            if (startJ >=0 && startI <crossword[0].length) {
                if (!(word.charAt(i) == (char)crossword[startJ][startI])) {
                    finded = false;
                    break;
                }
            } else {
                finded = false;
                break;
            }
        }

        if (!finded) {
            startJ = jStart;
            startI = iStrat;
            finded = true;
            for (int i = 1; i < word.length(); i++) {
                startJ++;
                startI--;
                if (startJ < crossword.length && startI >=0) {
                    if (!(word.charAt(i) == crossword[startJ][startI])) {
                        finded = false;
                        break;
                    }
                } else {
                    finded = false;
                    break;
                }
            }
        }
        if(finded){
            Word w = new Word(word);
            w.setStartPoint(iStrat, jStart);
            w.setEndPoint(startI,startJ);
            return w;
        } else {
            return null;
        }
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
