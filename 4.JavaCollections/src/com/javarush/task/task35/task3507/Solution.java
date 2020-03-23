package com.javarush.task.task35.task3507;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<Animal> set = new HashSet<>();

        MyClassLoader cl = new MyClassLoader();
       String path =  pathToAnimals;
       if(path.charAt(path.length()-1)!='/'){
           path = path +"/";
       }
       File file = new File(path);
       File[] files = file.listFiles();
       for(File f : files){
           if(f.getAbsolutePath().endsWith(".class")){
               Class clazz = cl.load(Paths.get(f.getAbsolutePath()));
               Class<?>[] interfaces = clazz.getInterfaces();
               for(Class i : interfaces){
                   if(i.getSimpleName().equals("Animal")){
                       Constructor[] constr = clazz.getConstructors();
                       for(Constructor c : constr){
                           int modif = c.getModifiers();
                           if(Modifier.isPublic(modif)){
                               if(c.getParameterCount()==0){
                                  set.add((Animal)c.newInstance());
                               }
                           }
                       }
                   }
               }
           }
       }


        return set;
    }

    public static class MyClassLoader extends ClassLoader {
        public Class<?> load(Path path){
            try{
                byte[] clazz = Files.readAllBytes(path);
               return defineClass(null,clazz,0,clazz.length);
            }catch (Exception e){

            }

            return null;
        }
    }
}
