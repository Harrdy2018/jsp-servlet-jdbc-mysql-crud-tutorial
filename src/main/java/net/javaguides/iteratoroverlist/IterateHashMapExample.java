package net.javaguides.iteratoroverlist;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class IterateHashMapExample {
    public static void main(String[] args) {
        // 1. Iterate through HashMap EntrySet using Iterator
        Map<Integer, String> coursesMap=new HashMap<>();
        coursesMap.put(1,"C");
        coursesMap.put(2,"C++");
        coursesMap.put(3,"Java");
        coursesMap.put(4,"Python");
//        Set<Map.Entry<Integer, String>> entrySet= coursesMap.entrySet();
//        System.out.println(entrySet);
//        Iterator<Map.Entry<Integer, String>> iterator=entrySet.iterator();
//        while(iterator.hasNext()){
//            Map.Entry<Integer, String> node=iterator.next();
//            System.out.println("key="+node.getKey()+" "+"value="+node.getValue());
//        }

        // 2. Iterate through HashMap keySet using Iterator
        Iterator<Integer> iterator=coursesMap.keySet().iterator();
        while(iterator.hasNext()){
            Integer key=iterator.next();
            System.out.println("key="+key+" "+"value="+coursesMap.get(key));
        }

        // 3. Iterate HashMap using for-Each Loop
        for(Map.Entry<Integer, String> entry:coursesMap.entrySet()){
            System.out.println("key="+entry.getKey()+" "+"value="+entry.getValue());
        }

        // 4. Iterate HashMap using Lambda Expression
        coursesMap.forEach((Integer key,String value)->System.out.println("key="+key+" "+"value="+value));

        // 5. Iterate HashMap using Stream API
        coursesMap.entrySet().stream().forEach(entry->{
            System.out.println("key="+entry.getKey()+" "+"value="+entry.getValue());
        });
    }
}
