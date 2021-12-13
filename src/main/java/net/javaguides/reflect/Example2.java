package net.javaguides.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
 * 通过Class对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员；
 *
 * 1.获取构造方法：
 * 		1).批量的方法：
 * 			public Constructor[] getConstructors()：所有"公有的"构造方法
            public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)

 * 		2).获取单个的方法，并调用：
 * 			public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法：
 * 			public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有；
 *
 * 			调用构造方法：
 * 			Constructor-->newInstance(Object... initargs)
*/
public class Example2 {
    public static void main(String[] args) throws Exception {
        Class clazz=Class.forName("net.javaguides.reflect.Student");

        Constructor constructor[] = clazz.getConstructors();
        for(Constructor c:constructor){
            System.out.println(c);
        }

        System.out.println("***********");
        constructor=clazz.getDeclaredConstructors();
        for(Constructor c:constructor){
            System.out.println(c);
        }

        System.out.println("***********");
        Constructor con=clazz.getConstructor(null);
        System.out.println(con);

        // 调用无参构造方法
        System.out.println("****调用无参构造方法*******");
        Constructor conA=clazz.getConstructor(null);
        Object o=conA.newInstance();
        System.out.println(o);

        // 获取私有构造方法并调用
        System.out.println("*****获取私有构造方法并调用******");
        Constructor conB=clazz.getDeclaredConstructor(char.class);
        conB.setAccessible(true); // 暴力访问
        Object o1=conB.newInstance('男');
        System.out.println(o1);
    }
}
