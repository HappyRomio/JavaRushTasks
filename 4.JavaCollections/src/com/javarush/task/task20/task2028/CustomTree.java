package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root = new Entry<String>("root");
    ArrayDeque<Entry<String>> deque = new ArrayDeque<Entry<String>>();
    CustomTree(){
        root = new Entry<>("root");
    }
    @Override
    public boolean add (String elementName){
        deque.addFirst(root);
        while(deque.size()!=0) {
            Entry<String> s = deque.pollFirst();

            if (s != null) {
                if (s.isAvailableToAddChildren()) {
                    if (s.availableToAddLeftChildren) {
                        s.leftChild = new Entry<String>(elementName);
                        s.leftChild.parent = s;
                        s.availableToAddLeftChildren = false;
                        while(deque.poll()!=null);
                        return true;
                    }else {
                        if (s.availableToAddRightChildren) {
                            s.rightChild = new Entry<String>(elementName);
                            s.rightChild.parent = s;
                            s.availableToAddRightChildren = false;
                            while (deque.poll() != null) ;
                            return true;
                        }
                    }
                } else {

                    if (s.leftChild != null) {
                        deque.addLast(s.leftChild);
                    }
                    if (s.rightChild != null) {
                        deque.addLast(s.rightChild);
                    }

                }
            }
        }
        deque.addFirst(root);
        while(deque.size()!=0) {
            Entry<String> s = deque.pollFirst();

            if(s.leftChild==null && s.rightChild==null && !s.availableToAddRightChildren && !s.availableToAddLeftChildren){
                s.availableToAddLeftChildren=true;
                s.availableToAddRightChildren=true;
            }else{

            }

            if (s.leftChild != null) {
                deque.addLast(s.leftChild);
            }
            if (s.rightChild != null) {
                deque.addLast(s.rightChild);
            }
        }
        System.out.println(this.size());
        deque.addFirst(root);
        while(deque.size()!=0) {
            Entry<String> s = deque.pollFirst();

            if (s != null) {
                if (s.isAvailableToAddChildren()) {
                    if (s.availableToAddLeftChildren) {
                        s.leftChild = new Entry<String>(elementName);
                        s.leftChild.parent = s;
                        s.availableToAddLeftChildren = false;
                        while(deque.poll()!=null);
                        return true;
                    }else {
                        if (s.availableToAddRightChildren) {
                            s.rightChild = new Entry<String>(elementName);
                            s.rightChild.parent = s;
                            s.availableToAddRightChildren = false;
                            while (deque.poll() != null) ;
                            return true;
                        }
                    }
                } else {

                    if (s.leftChild != null) {
                        deque.addLast(s.leftChild);
                    }
                    if (s.rightChild != null) {
                        deque.addLast(s.rightChild);
                    }

                }
            }
        }

        return false;
    }

    @Override
    public int size() {
        int i = 1;
        deque.add(root);
        while(deque.size()!=0){
            Entry<String> s = deque.pollFirst();
           // System.out.println(s.elementName);
                if(s.leftChild!=null) {
                    deque.addLast(s.leftChild);
                    i++;
                }
                if(s.rightChild!=null) {
                    deque.addLast(s.rightChild);
                    i++;
                }
        }
        return i-1;
    }

    public String getParent(String s){
        deque.add(root);
        while(deque.size()!=0){
            Entry<String> entry = deque.pollFirst();
            if(entry.elementName.equals(s)){
                    return entry.parent.elementName;
            }
           // System.out.println(entry.elementName);
            if(entry.leftChild!=null) {
                deque.addLast(entry.leftChild);
            }
            if(entry.rightChild!=null) {
                deque.addLast(entry.rightChild);
            }
        }
        return "null";
    }
    @Override
    public boolean remove(Object name){
        if(!(name instanceof String)){
            throw new UnsupportedOperationException();
        }
        Entry<String> elemRemove = null;
        deque.add(root);
        while(deque.size()!=0){
            Entry<String> entry = deque.pollFirst();
            if(entry.elementName.equals(name)){
                elemRemove = entry;
            }
            if(elemRemove == null) {
                if (entry.leftChild != null) {
                    deque.addLast(entry.leftChild);
                }
                if (entry.rightChild != null) {
                    deque.addLast(entry.rightChild);
                }
            }else {
                while(deque.pollFirst() !=null);
            }
        }

        deque.add(elemRemove);
        if (elemRemove.parent.rightChild!=null&&elemRemove.parent.rightChild.equals(elemRemove)) {
            elemRemove.parent.rightChild=null;
        }
        if (elemRemove.parent.leftChild!=null && elemRemove.parent.leftChild.equals(elemRemove)) {
            elemRemove.parent.leftChild=null;

        }
        while(deque.size()!=0) {
            Entry<String> entry = deque.pollFirst();
            if (entry.leftChild != null) {
                deque.addLast(entry.leftChild);
            }
            if (entry.rightChild != null) {
                deque.addLast(entry.rightChild);
            }
            entry.parent=null;
            entry.rightChild=null;
            entry.leftChild=null;

        }

        return true;

    }

    @Override
    public String get(int index){
        throw new UnsupportedOperationException();
    }
    @Override
    public String set(int index, String element){
        throw new UnsupportedOperationException();
    }
    @Override
    public void add(int index, String element){
        throw new UnsupportedOperationException();
    }
   /* @Override
    public String remove(int index){
        throw new UnsupportedOperationException();
    }*/
    @Override
    public List<String> subList(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }
    @Override
    protected void removeRange(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean addAll(int index, Collection<? extends String> c){
        throw new UnsupportedOperationException();
    }
    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName){
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }
        public boolean isAvailableToAddChildren(){
            return (availableToAddLeftChildren||availableToAddRightChildren);
        }
    }


}
