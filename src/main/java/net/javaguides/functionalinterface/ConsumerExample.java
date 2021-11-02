package net.javaguides.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<Person> list=new ArrayList<>();
        list.add(new Person("Tony",45));
        list.add(new Person("Tom",45));

        // forEach
        list.forEach((person)->{
            System.out.println(person.getName()+" "+person.getAge());
        });

        System.out.println("implement forEach method...");
        Consumer<Person> consumer=(person)->{
            System.out.println(person.getName()+" "+person.getAge());
        };
        consumer.accept(new Person("huawei", 13));
    }
}
