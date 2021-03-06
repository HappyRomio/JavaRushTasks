package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class Restaurant {
    public static void main(String... args){
        Tablet tablet = new Tablet(1);

        Cook cook = new Cook("Amigo");
        tablet.addObserver(cook);
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        tablet.createOrder();

        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();

    }
}
