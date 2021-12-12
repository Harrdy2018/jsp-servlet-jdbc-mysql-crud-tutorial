package net.javaguides.BaseMethods;

public class Example1 {
    public static void main(String[] args) {
        // String.valueOf() 将基本数据类型态转化为String
        // boolean
        System.out.println(String.valueOf(false)); // "false"
        System.out.println(String.valueOf('A')); // "A"

        // array
        char arr1[]={'a','b','c'};
        System.out.println(String.valueOf(arr1)); // "abc"
        System.out.println(String.valueOf(arr1,1,2)); // "bc"

        // double
        double dd = 1.34;
        System.out.println(String.valueOf(dd)); // "1.34"

        // float
        float f = 1.234F;
        System.out.println(String.valueOf(f)); // "1.234"

        // int
        int i =234;
        System.out.println(String.valueOf(i)); // "234"

        // long
        long l = 23456L;
        System.out.println(String.valueOf(l)); // "23456"

        // Object
        Object o = new String("Hello");
        System.out.println(String.valueOf(o)); // Hello
    }
}
