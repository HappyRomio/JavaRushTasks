package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        Zerg zerg1 = new Zerg();
        zerg1.name = "s";
        Zerg zerg2 = new Zerg();
        zerg2.name = "sw";
        Zerg zerg13 = new Zerg();
        zerg13.name = "s3";
        Zerg zerg14 = new Zerg();
        zerg14.name = "s4";
        Zerg zerg15 = new Zerg();
        zerg15.name = "s5";

        Protoss proto1 = new Protoss();
        proto1.name = "p00";
        Protoss proto1w = new Protoss();
        proto1w.name ="dsf";
        Protoss proto1e = new Protoss();
        proto1e.name = "sds";

        Terran terr1 = new Terran();
        terr1.name = "sdfsd";
        Terran terr1w = new Terran();
        terr1w.name = "ssxv";
        Terran terr13 = new Terran();
        terr13.name = "ssxv2";
        Terran terr12 = new Terran();
        terr12.name = "ssxv3";
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
