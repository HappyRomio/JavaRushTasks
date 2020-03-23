package com.javarush.task.task36.task3606;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem(){
        try {
            ClassLoaderFromPath cLoader = new ClassLoaderFromPath();
            packageName.replace(FileSystems.getDefault().getSeparator(),"/");
            Object[] list = Files.list(Paths.get(packageName.replaceFirst("/",""))).filter(f-> f.toString().endsWith("class")).toArray();
            for(Object o : list){
                System.out.println(((Path)o).toString());
                Class clazz= cLoader.load((Path)o);
                hiddenClasses.add(clazz);
            }
        }catch (Exception e){
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        try {


            for (Class clazz : hiddenClasses) {
                if (clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                    Constructor constructor =clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    return (HiddenClass) constructor.newInstance();
                }
            }
        }catch (Exception e){
            return null;
        }

        return null;
    }

    public static class ClassLoaderFromPath extends ClassLoader {
        public Class<?> load(Path path) {
            try {
                byte[] b = Files.readAllBytes(path);
                return defineClass(null, b, 0, b.length);
            } catch (Exception e) {
            }
            return null;
        }
    }
}

