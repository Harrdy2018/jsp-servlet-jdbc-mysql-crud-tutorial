package net.javaguides.iteratoroverlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DifferentWaystoIterateOverList {
    public static void main(String[] args) {
        List<String> courses= Arrays.asList("C","C++","Java");

        // basic for loop
        for(int i=0;i<courses.size();i++){
            System.out.println(courses.get(i));
        }

        // Enhanced for each loop
        for(String s:courses){
            System.out.println(s);
        }

        // iterator with while loop
        Iterator<String> ite=courses.iterator();
        while(ite.hasNext()){
            System.out.println(ite.next());
        }

        // java 8 stream + lambda example
        courses.stream().forEach(x->System.out.println(x));

        // java 8 forEach + lambda example
        courses.forEach(x->System.out.println(x));
    }
}
