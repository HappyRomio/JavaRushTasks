package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
           String[] wheelsS = loadWheelNamesFromDB();
           wheels = new ArrayList<>();
            wheels.add(Wheel.valueOf(wheelsS[0]));
            wheels.add(Wheel.valueOf(wheelsS[1]));
            wheels.add(Wheel.valueOf(wheelsS[2]));
            wheels.add(Wheel.valueOf(wheelsS[3]));
            if(wheelsS.length==4 && wheels.contains(Wheel.FRONT_LEFT) && wheels.contains(Wheel.FRONT_RIGHT)
                    && wheels.contains(Wheel.BACK_LEFT) && wheels.contains(Wheel.BACK_RIGHT)){

            }else{
                throw new Exception();
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) throws Exception {
        Car car = new Car();
    }
}
