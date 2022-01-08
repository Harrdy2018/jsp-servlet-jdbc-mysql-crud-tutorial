package net.javaguides.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Range {
    int min() default 0;
    int max() default 255;
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface IntegerValue {
    int value() default 0;
    String name() default "";
}

class Person {
    @Range(min = 3, max = 10)
    public String name;

    @Range(min = 5, max = 20)
    public String address;

    @IntegerValue(20)
    public int age;

    @IntegerValue(value = 1000, name = "MONEY")
    public int money;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}

public class Example1 {
    public static void main(String[] args) throws Exception{
        // 判断字段上是否存在针对指定类型的注解
        Field name = Person.class.getField("name");
        System.out.println(name.isAnnotationPresent(Range.class));

        Field age = Person.class.getField("age");
        System.out.println(age.isAnnotationPresent(IntegerValue.class));

        // 获取字段上针对指定类型的注解
        Range rangeName = name.getAnnotation(Range.class);
        System.out.println(rangeName.min()+"  "+rangeName.max());

        IntegerValue integerValueAge = age.getAnnotation(IntegerValue.class);
        System.out.println(integerValueAge.value());

        // check
        Person person = new Person("xm", "111110@qq.com");
        for (Field field : person.getClass().getFields()) {
            Range range = field.getAnnotation(Range.class);
            if (range != null) {
                Object fieldValue = field.get(person);
                if (fieldValue instanceof String) {
                    String value = (String)fieldValue;
                    if (value.length() < range.min() || value.length() > range.max()) {
                        throw new AssetException("Illegal field: "+field.getName());
                    }
                }
            }
        }
    }
}
