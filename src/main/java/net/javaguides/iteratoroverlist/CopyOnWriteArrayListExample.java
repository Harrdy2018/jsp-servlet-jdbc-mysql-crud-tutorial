package net.javaguides.iteratoroverlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        /*
        // 报错 java.util.ConcurrentModificationException
        List<String> list=new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Iterator<String> iterator=list.iterator();
        while(iterator.hasNext()){
            String str=iterator.next();
            if(str.equals("one")){
                list.remove("one");
            }
            if(str.equals("three")){
                list.add("four");
            }
        }
        */

        List<String> list=new CopyOnWriteArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Iterator<String> iterator=list.iterator();
        while(iterator.hasNext()){
            String str=iterator.next();
            System.out.println(str);
            if(str.equals("one")){
                list.remove("one");
            }
            if(str.equals("three")){
                list.add("four");
            }
            System.out.println(list);
        }
    }
}
