package com.javarush.task.task34.task3404;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/
public class Solution {






    public static void main(String[] args) {
        Solution solution = new Solution();



        solution.recurse("(-1 + (-2))", 0);  System.out.println("-3 3 - expected output");
        solution.recurse("-sin(2*(-5+1.5*4)+28)", 0);  System.out.println("-0.5 7 - expected output");
        solution.recurse("sin(100)-sin(100)", 0);  System.out.println("0 3 - expected output");
        solution.recurse("-(-22+22*2)", 0);  System.out.println("-22 4 - expected output");
        solution.recurse("-2^(-2)", 0);  System.out.println("-0.25 3 - expected output");
        solution.recurse("-(-2^(-2))+2+(-(-2^(-2)))", 0);  System.out.println("2.5 10 - expected output");
        solution.recurse("(-2)*(-2)", 0);  System.out.println("4 3 - expected output");
        solution.recurse("(-2)/(-2)", 0);  System.out.println("1 3 - expected output");
        solution.recurse("sin(-30)", 0);  System.out.println("-0.5 2 - expected output");
        solution.recurse("cos(-30)", 0);  System.out.println("0.87 2 - expected output");
        solution.recurse("tan(-30)", 0);  System.out.println("-0.58 2 - expected output");
        solution.recurse("2+8*(9/4-1.5)^(1+1)", 0);  System.out.println("6.5 6 - expected output");
        solution.recurse("0.005", 0);  System.out.println("0.01 0 - expected output");
        solution.recurse("0.0049", 0);  System.out.println("0 0 - expected output");
        solution.recurse("0+0.304", 0);  System.out.println("0.3 1 - expected output");
        solution.recurse("sin(45) - cos(45)", 0);  System.out.println("0 3 - expected output");
        solution.recurse("0/(-3)", 0);  System.out.println("0 2 - expected output");
        solution.recurse("-(-2^(-2))+2+(-(-2^(-2)))", 0);  System.out.println("2.5 10 - expected output");
        solution.recurse("(-2)*(-2)", 0);  System.out.println("4 3 - expected output");
        solution.recurse("(-2)/(-2)", 0);  System.out.println("1 3 - expected output");
        solution.recurse("sin(-30)", 0);  System.out.println("-0.5 2 - expected output");
        solution.recurse("cos(-30)", 0);  System.out.println("0.87 2 - expected output");
        solution.recurse("tan(-30)", 0);  System.out.println("-0.58 2 - expected output");
        solution.recurse("2+8*(9/4-1.5)^(1+1)", 0);  System.out.println("6.5 6 - expected output");
        solution.recurse("0.005", 0);  System.out.println("0.01 0 - expected output");
        solution.recurse("0.0049", 0);  System.out.println("0 0 - expected output");
        solution.recurse("0+0.304", 0);  System.out.println("0.3 1 - expected output");
        solution.recurse("sin(45) - cos(45)", 0);  System.out.println("0 3 - expected output");
        solution.recurse("0/(-3)", 0);  System.out.println("0 2 - expected output");

    }

    public void recurse(final String expression, int countOperation) {
        Pattern border = Pattern.compile("\\([\\+\\-\\*\\.\\/\\^0-9 ]+\\)");
        Pattern borderedResult = Pattern.compile("^\\(\\-{0,1}[ 0-9\\.]*\\)$");
        Pattern multiply = Pattern.compile("(?:(?<=^|\\()[\\-0-9 \\.]+\\*[0-9 \\-\\.]{0,1}[0-9 \\.]+|[ 0-9\\.]+\\*[ 0-9\\-\\.]{0,1}[ 0-9\\.]+)");
        Pattern divide = Pattern.compile("(?:(?<=^|\\()[\\-0-9 \\.]+/[ 0-9\\-\\.]{0,1}[ 0-9\\.]+|[ 0-9\\.]+/[ 0-9\\-\\.]{0,1}[ 0-9\\.]+)");
        Pattern pow = Pattern.compile("[\\-]{0,1}[0-9\\.]+\\^[\\-]{0,1}[0-9\\.]+");
        Pattern unaryMinus = Pattern.compile("-\\([\\-\\+0-9\\.]+");
        Pattern signReverse = Pattern.compile("_\\([\\+\\-\\*\\.\\/\\^0-9 ]+\\)");
        Pattern sin = Pattern.compile("sin\\(\\-{0,1}[ 0-9\\.]*\\)");
        Pattern cos = Pattern.compile("cos\\(\\-{0,1}[ 0-9\\.]*\\)");
        Pattern tan = Pattern.compile("tan\\(\\-{0,1}[ 0-9\\.]*\\)");
        Pattern end = Pattern.compile("^\\-{0,1}[ 0-9\\.]*$");
        Pattern unariPlusDigit = Pattern.compile("(^|[\\/\\*\\^\\(])\\+[\\-0-9\\.]+");
        Pattern digit = Pattern.compile("[\\-\\+]{0,1}[0-9\\.]+");
        Pattern digits = Pattern.compile(  "[\\-]{0,1}[0-9\\.]+[\\+\\-\\*\\/][\\-0-9\\.]+");
        String expression1 = expression.replace(" ","");
        int count = countOperation;
        if(countOperation==0){
            for(int i =0 ; i < expression.length();i++){
                if(expression.charAt(i)=='-'||expression.charAt(i)=='+' || expression.charAt(i)=='*' || expression.charAt(i)=='/' || expression.charAt(i)=='^'){
                    count++;
                }
            }

            String[] words = expression.split("\\(");
            for(String word : words){
                if(word.contains("sin") ||word.contains("cos")||word.contains("tan") )
                {
                    count++;
                }
            }

        }
        Matcher matcher = end.matcher(expression1);
        if(matcher.find()){
            BigDecimal result = BigDecimal.valueOf(Double.parseDouble(matcher.group()));
            DecimalFormat df = new DecimalFormat("0.##");
            df.setMaximumFractionDigits(2);
            String res = df.format(result.doubleValue());
            result = BigDecimal.valueOf(Double.parseDouble(res.replace(",",".")));
            res = result.setScale(2, RoundingMode.UP).toString();
            res = res.replace(".00","");
            if(res.charAt(res.length()-1)=='0'&& res.length()>1){
                res = res.substring(0,res.length()-1);
            }


            if(result.doubleValue()<0){
                countOperation++;
            }
            System.out.println(res + " " + count);
        }else{

            matcher=unaryMinus.matcher(expression1);
            if(matcher.find()){
                String first = matcher.group();
                String result = first.replaceFirst(Pattern.quote("-"),"_");
                recurse(expression1.replace(first, result),count);
                return;
            }


        matcher=unariPlusDigit.matcher(expression1);
            if(matcher.find()){
                recurse(expression1.replace(matcher.group(),matcher.group().replace("+","")),count);
                return;
            }

            matcher=signReverse.matcher(expression1);
            if(matcher.find()){
                String first = matcher.group();
                String second = first;
                matcher =digit.matcher(first);

                while(matcher.find()) {
                    String digitBefore = matcher.group();
                    String digitAfter = "";
                    if(first.charAt(matcher.start()-1)!='^') {
                        if (digitBefore.charAt(0) == '-') {
                            digitAfter = digitBefore.replace("-", "+");
                        } else if (digitBefore.charAt(0) == '+') {
                            digitAfter = digitBefore.replace("+", "-");
                            ;
                        } else {
                            digitAfter = "-" + digitBefore;
                        }
                    } else {
                        digitAfter = digitBefore;
                    }
                        first = first.replaceFirst(Pattern.quote(digitBefore), digitAfter);

                }
                first=first.replace("_","+");
                String exp= expression1.replaceFirst(Pattern.quote(second),first);

                recurse(exp.replace("++","+").replace("-+","-"),countOperation);
                return;
            }

            matcher=sin.matcher(expression1);
        if(matcher.find()){
            String first = matcher.group();
            String result;
            result = first.replace("sin(","");
            result = result.replace(")","");
            Double sinus = Double.parseDouble(result);
            if(sinus < 0.0) {
               sinus=sinus*-1;
               result = String.valueOf(-1*(Math.sin(sinus*Math.PI / 180)));
               recurse(expression1.replace(first, result), count);
               return;
            }else {
                result = String.valueOf(Math.sin(Double.parseDouble(result)*Math.PI / 180));
                recurse(expression1.replace(first, result), count);
                return;
            }
        }

        matcher=cos.matcher(expression1);
        if(matcher.find()){
            String first = matcher.group();
            String result;
            result = first.replace("cos(","");
            result = result.replace(")","");
            result = String.valueOf(Math.cos(Double.parseDouble(result)*Math.PI / 180));
            recurse(expression1.replace(first,result),count);
            return;
        }

        matcher=tan.matcher(expression1);
        if(matcher.find()){
            String first = matcher.group();
            String result;
            result = first.replace("tan(","");
            result = result.replace(")","");
            result = String.valueOf(Math.tan(Double.parseDouble(result)*Math.PI / 180));
            recurse(expression1.replace(first,result),count);
            return;
        }

        matcher=border.matcher(expression1);

        if(matcher.find()) {
            String inBorder = matcher.group();
            if(inBorder.replaceFirst("\\(\\-[0-9\\.]+\\)","").length()==0){
                ++countOperation;
            }
            matcher = borderedResult.matcher(inBorder);
            if (matcher.find()) {
                recurse(expression1.replace(inBorder, inBorder.substring(1, inBorder.length() - 1)), count);
                return;
            }


            matcher = pow.matcher(inBorder);
            if (matcher.find()) {
                String first = matcher.group();
                String result = String.valueOf(Math.pow(Double.parseDouble(first.split("\\^")[0]), Double.parseDouble(first.split("\\^")[1])));
                recurse(expression1.replace(inBorder, inBorder.replace(first, result)), count);
                return;
            }

            int indexOfMult= inBorder.indexOf("*");
            int indexOfDev = inBorder.indexOf("/");
            if(indexOfMult < indexOfDev || indexOfDev ==-1) {
                matcher = multiply.matcher(inBorder);
                if (matcher.find()) {
                    String first = matcher.group();
                    String result = String.valueOf(Double.parseDouble(first.split("\\*")[0]) * Double.parseDouble(first.split("\\*")[1]));
                    recurse(expression1.replace(inBorder, inBorder.replace(first, result)), count);
                    return;
                }
            }else {
                matcher = divide.matcher(inBorder);
                if (matcher.find()) {
                    String first = matcher.group();
                    String result = String.valueOf(Double.parseDouble(first.split("/")[0]) / Double.parseDouble(first.split("/")[1]));
                    recurse(expression1.replace(inBorder, inBorder.replace(first, result)), count);
                    return;
                }
            }


            matcher = digits.matcher(inBorder);
            matcher.find();
            String expre = matcher.group();
            String sign = expre.replaceAll("(?<![0-9])[\\-]{0,1}[0-9\\.]+","");
            if(sign.equals("-")) {
                String a = expre.substring(0,expre.indexOf("-", 1));
                String b = expre.substring(expre.indexOf("-", 1)).replaceFirst("-","");
                String result = String.valueOf(Double.parseDouble(a) - Double.parseDouble(b));
                recurse(expression1.replace(inBorder,inBorder.replace(expre,result)),count);
                return;
            }

            if(sign.equals("+")){
                String a = expre.substring(0,expre.indexOf("+", 1));
                String b = expre.substring(expre.indexOf("+", 1)).replaceFirst("\\+","");
                String result = String.valueOf(Double.parseDouble(a) + Double.parseDouble(b));
                recurse(expression1.replaceFirst(Pattern.quote(inBorder),inBorder.replace(expre,result)),count);
                return;
            }

        }
            matcher = pow.matcher(expression1);
            if (matcher.find()) {
                String first = matcher.group();
                String result = String.valueOf(Math.pow(Double.parseDouble(first.split("\\^")[0]), Double.parseDouble(first.split("\\^")[1]))*(first.split("\\^")[0].charAt(0)=='-' ?-1:1));
                recurse(expression1.replace(expression1, expression1.replaceFirst(pow.toString(), result)), count);
                return;
            }
            matcher = multiply.matcher(expression1);
            if (matcher.find()) {
                String first = matcher.group();
                String result = String.valueOf(Double.parseDouble(first.split("\\*")[0]) * Double.parseDouble(first.split("\\*")[1]));
                recurse(expression1.replace(expression1, expression1.replace(first, result)), count);
                return;
            }
            matcher = divide.matcher(expression1);
            if (matcher.find()) {
                String first = matcher.group();
                String result = String.valueOf(Double.parseDouble(first.split("/")[0]) / Double.parseDouble(first.split("/")[1]));
                recurse(expression1.replace(expression1, expression1.replace(first, result)), count);
                return;
            }


            matcher = digits.matcher(expression1);
            matcher.find();
            String expre = matcher.group();
            String sign = String.valueOf(expre.replaceAll("(?<![0-9])[\\-]{0,1}[0-9\\.]+","").charAt(0));
            if(sign.equals("-")) {
                String a = expre.substring(0,expre.indexOf("-", 1));
                matcher = digit.matcher(expre.substring(expre.indexOf("-", 1)).replaceFirst("-",""));
                matcher.find();
                String b = matcher.group();
                DecimalFormat df = new DecimalFormat("#");
                df.setMaximumFractionDigits(2);
                String result = df.format(Double.parseDouble(a) - Double.parseDouble(b)).replace(",",".");
                recurse(expression1.replace(expression1, expression1.replaceFirst(Pattern.quote(a+"-"+b),result)),count);
                return;
            }

            if(sign.equals("+")){
                String a = expre.substring(0,expre.indexOf("+", 1));
                matcher = digit.matcher(expre.substring(expre.indexOf("+", 1)).replaceFirst("\\+",""));
                matcher.find();
                String b = matcher.group();
                DecimalFormat df = new DecimalFormat("#");
                df.setMaximumFractionDigits(2);
                String result = df.format(Double.parseDouble(a) + Double.parseDouble(b)).replace(",",".");
                recurse(expression1.replace(expression1, expression1.replaceFirst(Pattern.quote(a+"+"+b),result)),count);
                return;
            }


        }

    }



    public Solution() {
        //don't delete
    }
}
