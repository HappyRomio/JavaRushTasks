package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number;
    private Order order;
    private static Logger logger =Logger.getLogger(Tablet.class.getName());


    Tablet(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Order createOrder() {
        try{
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            if(!order.isEmpty()) {
                setChanged();
                notifyObservers(order);
            }
            return order;
        }catch (IOException e){
            logger.log(Level.SEVERE,"Console is unavailable.");
            return null;
        }
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString(){
        return "Tablet{number=" + number +"}";
    }


}
