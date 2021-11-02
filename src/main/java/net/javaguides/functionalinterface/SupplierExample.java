package net.javaguides.functionalinterface;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Person> supplier=()->{
            return new Person("oppo", 29);
        };

        Person person=supplier.get();
        System.out.println(person.getName());
        System.out.println(person.getAge());
    }
}
