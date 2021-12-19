package net.javaguides.interview;

import java.lang.reflect.Field;

public class Example1 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String s = new String("abc");
        // 在这中间可以添加N行代码，但必须保证s指向不变，最终将输出变为"abcd"
        Class clazz = s.getClass();
        Field f = clazz.getDeclaredField("value");
        System.out.println(f);
        f.setAccessible(true);
        f.set(s, "abcd".toCharArray());
        System.out.println(s);
    }
}
