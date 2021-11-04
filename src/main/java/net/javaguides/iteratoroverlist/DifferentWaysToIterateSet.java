package net.javaguides.iteratoroverlist;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DifferentWaysToIterateSet {
    public static void main(String[] args) {
        Set<String> courses=new HashSet<>();
        courses.add("Java");
        courses.add("C");
        courses.add("C++");
        courses.add("Python");

        // Enhanced for loop
        for(String course:courses){
            System.out.println(course);
        }
        // Basic loop with iterator
        for(Iterator<String> iterator=courses.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }
        // while loop with iterator
        Iterator<String> iterator=courses.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        // JDK 8 forEach() method with lambda'
        courses.forEach((course)->System.out.println(course));
        // JDK 8 streaming+forEach()+lambda expression
        courses.stream().filter((course)->!"Java".equals(course))
                .forEach(course->System.out.println(course));
    }
}
