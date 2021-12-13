package net.javaguides.reflect;

public class Example1 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 第一种方式获取Class对象
        // getClass() 返回一个对象的运行时类
        Student student=new Student();
        Class classA=student.getClass();
        System.out.println(classA.getClass()); // class net.javaguides.reflect.Student
        System.out.println(classA.getClass().getName()); // net.javaguides.reflect.Student

        // 第二种方式获取Class对象
        Class classB=Student.class;
        System.out.println(classA==classB); // true

        // 第三种方式获取Class对象
        Class classC=Class.forName("net.javaguides.reflect.Student");
        System.out.println(classC == classB); // true
    }
}
