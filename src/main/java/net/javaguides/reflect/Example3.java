package net.javaguides.reflect;

import java.io.File;
import java.lang.reflect.Field;

/*
 * 获取成员变量并调用：
 *
 * 1.批量的
 * 		1).Field[] getFields():获取所有的"公有字段"
 * 		2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
 * 2.获取单个的：
 * 		1).public Field getField(String fieldName):获取某个"公有的"字段；
 * 		2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
 *
 * 	 设置字段的值：
 * 		Field --> public void set(Object obj,Object value):
 * 					参数说明：
 * 					1.obj:要设置的字段所在的对象；
 * 					2.value:要为字段设置的值；
 *
 */
public class Example3 {
    public static void main(String[] args) throws Exception{
        Class clazz=Class.forName("net.javaguides.reflect.Student");
        System.out.println("获取所有公有的字段");
        Field fields[] = clazz.getFields();
        for(Field f : fields){
            System.out.println(f);
        }
        System.out.println("获取所有字段、私有、受保护、默认");
        fields=clazz.getDeclaredFields();
        for(Field f : fields){
            System.out.println(f);
        }

        System.out.println("获取一个公有字段并设置");
        Field fieldA = clazz.getField("name");
        Object obj = clazz.getConstructor().newInstance();
        fieldA.set(obj, "oppo");
        System.out.println(obj);

        System.out.println("获取一个私有字段并设置");
        Field fieldB = clazz.getDeclaredField("phoneNum");
        Object objB = clazz.getConstructor().newInstance();
        fieldB.setAccessible(true);
        fieldB.set(objB, "123456789");
        System.out.println(objB);
    }
}
