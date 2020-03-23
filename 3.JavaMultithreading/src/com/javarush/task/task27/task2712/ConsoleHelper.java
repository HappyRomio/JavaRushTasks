package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        String order = "";
        List<Dish> fullOrder = new ArrayList<>();
        writeMessage("Выберите блюдо:");
        writeMessage(Dish.allDishesToString());
        while (!order.equalsIgnoreCase("exit")){
            order = br.readLine();
            if(order.equalsIgnoreCase("exit"))
                break;
            if(!Dish.allDishesToString().contains(order)){
                writeMessage("Данное блюдо отсутствует в меню");
            }else{
            fullOrder.add(Dish.valueOf(order));
            }
        }
        return fullOrder;
    }

}
