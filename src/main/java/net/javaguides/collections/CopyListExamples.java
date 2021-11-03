package net.javaguides.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CopyListExamples {
    public static void main(String[] args) {
        // Copy a list into Another List in Java (6 ways)
        // 1. Using constructor
        List<String> fruits=new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Appale");
        fruits.add("Orange");
        System.out.println(fruits);
        List<String> copy=new ArrayList<>(fruits);
        System.out.println(copy);

        // 2. Using addAll()
        List<String> copyb=new ArrayList<>();
        copyb.addAll(fruits);
        System.out.println(copyb);

        // 3. Using Collections.copy()
        int initialCapacity=fruits.size();
        List<String> copyc=new ArrayList<>(initialCapacity);
        copyc.add("A");
        copyc.add("A");
        copyc.add("A");
        Collections.copy(copyc,fruits);
        System.out.println(copyc);

        // 4. Using Java8 stream
        List<String> copyd=fruits.stream().collect(Collectors.toList());
        System.out.println(copyd);

        // 5. Using Java10
        // List<String> copye=List.copyOf(fruits);
        // System.out.println(copye);
    }
}
