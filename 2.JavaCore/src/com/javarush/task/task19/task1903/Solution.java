package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }
    public static void main(String[] args) {


        String s = "";
        String test = "501234567";
        for(int i = 0; i < 10 - test.length(); i++){
            s= s + "0";
        }
        s=s+test;

        System.out.println( "+"+"23"+"("+s.substring(0,3) + ")"+s.substring(3,6)+"-"+ s.substring(6,8) + "-" + s.substring(8,10));

    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;

        IncomeDataAdapter(IncomeData incomeData){
            this.data=incomeData;
        }

        @Override
        public String getCompanyName() {
           return data.getCompany();
        }

        @Override
        public String getCountryName() {

            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String s = "";

            for(int i = 0; i < 10-String.valueOf(data.getPhoneNumber()).length(); i++){
                s= s + "0";
            }
            s=s+data.getPhoneNumber();

            return "+"+data.getCountryPhoneCode()+"("+s.substring(0,3) + ")"+s.substring(3,6)+"-"+ s.substring(6,8) + "-" + s.substring(8,10);

        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}