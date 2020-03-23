package com.javarush.task.task37.task3701;

import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.function.Consumer;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {
    @Override
    public Iterator<T> iterator() {
        return new RoundIterator<>();
    }

    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    public class RoundIterator<E> implements Iterator  {
        Iterator iter = Solution.super.iterator();

        RoundIterator() {
        }

        public boolean hasNext()
        {
            if(!iter.hasNext()){
                iter = Solution.super.iterator();
                return iter.hasNext();
            }
            return true;
        }

        @Override
        public Object next() {
            return  iter.next();
        }

        @Override
        public void remove() {
                iter.remove();
        }

        @Override
        public void forEachRemaining(Consumer action) {
            iter.forEachRemaining(action);
        }


    }
}
