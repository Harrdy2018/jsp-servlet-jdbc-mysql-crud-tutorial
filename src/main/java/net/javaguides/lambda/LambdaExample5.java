package net.javaguides.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaExample5 {
    public static void main(String[] args) {
        List<String> progLangs=new ArrayList<>();
        progLangs.add("c");
        progLangs.add("c++");
        progLangs.add("Java");
        for(String s:progLangs){
            System.out.println(s);
        }
        progLangs.forEach(element->System.out.println(element));
    }
}
