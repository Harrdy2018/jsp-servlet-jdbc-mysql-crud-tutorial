package net.javaguides.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface IntegerValue {
    int value() default 0;
    String name() default "";
}

class Person {
    @IntegerValue(20)
    public int age;

    @IntegerValue(value = 1000, name = "MONEY")
    public int money;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", money=" + money +
                '}';
    }
}

public class Example1 {
    public static void main(String[] args) {
        System.out.println(new Person());
    }
}
