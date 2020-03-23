package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable, Externalizable {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
                    out.write(staticString.getBytes());
                    out.writeInt(i);
                    out.writeInt(j);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            staticString= in.readLine();
            i= in.readInt();
            j= in.readInt();

        }
    }

    public static void main(String[] args) {

    }
}
