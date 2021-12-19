package net.javaguides.interview;

public class Example2 {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = "abc";
        System.out.println(s1==s2); // false

        String s3 = s1.intern();
        // String对象的intern方法，首先会检查字符串常量池中是否存在"abc"，如果存在则返回该字符串的引用
        // 如果不存在，则把"abc"添加到字符串常量池中，并返回该字符串常量的引用
        System.out.println(s2==s3); // true
    }
}
