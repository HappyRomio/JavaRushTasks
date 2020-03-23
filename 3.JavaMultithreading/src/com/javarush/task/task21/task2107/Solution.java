package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;

            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);


    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
        @Override
        public User clone(){
            User u = new User(this.age,this.name);
            return u;
        }
    }

    @Override
    public boolean equals(Object o){
        if(this==o)
            return true;
        if(o==null)
            return false;
        if(!(o instanceof Solution))
            return false;

        Solution sol = (Solution)o;
        return Objects.equals(users,sol.users);


    }

    @Override
    public int hashCode(){
        return Objects.hash(users);
    }

    @Override
    public Solution clone(){
        Solution sol = new Solution();

        for(Map.Entry<String,User> e : this.users.entrySet()){
            sol.users.put(e.getKey(),e.getValue());
        }

        return sol;
    }
}
