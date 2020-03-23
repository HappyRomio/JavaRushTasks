package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    int left, top, width, height;

    public void initialize( int left ) {
        this.left = left;

    }
    public void initialize( int left, int top ) {
        this.left = left;
        this.top = top;

    }
    public void initialize( int left, int top, int height ) {
        this.left = left;
        this.top = top;
        this.height = height;


    }
    public void initialize( int left, int top, int height, int width ) {
        this.left = left;
        this.top = top;
        this.height = height;
        this.width = width;

    }

    public static void main(String[] args) {

    }
}
