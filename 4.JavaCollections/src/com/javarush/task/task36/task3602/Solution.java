package com.javarush.task.task36.task3602;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collections;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class cl = Class.forName("java.util.Collections");
        ArrayList<Class> result = new ArrayList<>();

        Class[] cls = cl.getDeclaredClasses();

        for(Class c : cls) {
            int mod = c.getModifiers();

            if (Modifier.isPrivate(mod) && Modifier.isStatic(mod)) {
                    Class c2 = c.getSuperclass();
                for(Class i : c2.getInterfaces()){
                    if(i.toString().equals("interface java.util.List")) {
                        Constructor[]  cons = c.getDeclaredConstructors();
                        for(Constructor constr : cons){
                            constr.setAccessible(true);

                            if(constr.getParameterTypes().length==0) {
                                try {
                                    Method m = c.getDeclaredMethod("get", int.class);
                                    m.setAccessible(true);
                                    m.invoke(constr.newInstance(),0);
                                } catch (InvocationTargetException e){
                                    return c;
                                }
                            }

                        }

                    }
                }
            }

        }

        return null;
    }

}
