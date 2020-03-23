package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Order{
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime(){
        int durationTime = 0;
        for(Dish dish : dishes){
            durationTime+=dish.getDuration();
        }

        return durationTime;
    }

    public boolean isEmpty(){
        return dishes.size() == 0 ? true : false;
    }

    @Override
    public String toString(){
        StringJoiner sj = new StringJoiner(", ");
        for(Dish dish : dishes){
            sj.add(dish.name());
        }

        return dishes.size() == 0 ? "" : "Your order: [" + sj.toString() + "] of " + tablet.toString() + ", cooking time " + getTotalCookingTime() + "min";
    }

}
