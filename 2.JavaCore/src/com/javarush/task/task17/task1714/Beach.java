package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public synchronized static void main(String[] args) {
            Beach a = new Beach("AtlantaBeach",10, 5);
        Beach b = new Beach("AtlantaBeach2",100, 50);
        Beach c = new Beach("AtlantaBeach3",9, 5);
        Beach d = new Beach("AtlantaBeach4",10, 5);

        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(a));
        System.out.println(a.compareTo(a));
        System.out.println(b.compareTo(c));
        System.out.println(c.compareTo(b));
        System.out.println(a.compareTo(c));

    }

    @Override
    public synchronized int compareTo(Beach o) {
        int result= 0;
        if(this.quality > o.quality){
            result++;
        } else if (this.quality < o.quality) {
            result--;
        }

        if(this.distance < o.distance){
            result++;
        } else if (this.distance > o.distance) {
            result--;
        }
        return result;

    }
}
