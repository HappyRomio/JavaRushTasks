package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("d:/1.txt");
            InputStream inputStream = new FileInputStream("d:/1.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setMale(false);
            user.setCountry(User.Country.RUSSIA);
            user.setFirstName("Fritz");
            user.setLastName("Geiger");
            user.setBirthDate(new Date());
            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

            for(User us : loadedObject.users){
                System.out.println(us.getBirthDate().getTime());
                System.out.println(us.getCountry());
                System.out.println(us.getFirstName());
                System.out.println(us.getLastName());
                System.out.println(us.isMale());
            }


        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            StringJoiner jn = new StringJoiner(":::");

            for(User u : users) {

                jn.add(
                u.getBirthDate().getTime() + " " +
                u.getFirstName() + " " +
                u.getLastName() + " " +
                u.getCountry() + " " +
                u.isMale());
            }
            outputStream.write(jn.toString().getBytes());
        }

        public void load(InputStream inputStream) throws Exception {
            StringBuilder sb = new StringBuilder();

            while (inputStream.available()>0){
                sb.append((char)inputStream.read());
            }
            if(sb.length()>0) {
                for (String s : sb.toString().split(":::")) {
                    User us = new User();
                    String[] serUser = s.split(" ");
                    us.setBirthDate(new Date(Long.parseLong(serUser[0])));
                    us.setFirstName(serUser[1]);
                    us.setLastName(serUser[2]);
                    us.setCountry(User.Country.valueOf(serUser[3]));
                    us.setMale(Boolean.valueOf(serUser[4]));
                    users.add(us);

                }
            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
