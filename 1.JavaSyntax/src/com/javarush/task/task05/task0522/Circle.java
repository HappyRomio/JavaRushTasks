package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    public Circle() {
        x = 0.0;
        y = 0.0;
        radius = 0.0;
    }

    public Circle(double x) {
        this.x = x;
        y = 0.0;
        radius = 0.0;
    }

    public Circle(double x, double y) {
        this.x = x;
        this.y = y;
        radius = 0.0;
    }

    public Circle(Circle c) {
        this.x = c.x;
        this.y = c.y;
        radius = c.radius;
    }

    public static void main(String[] args) {

    }
}