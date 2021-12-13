package net.javaguides.reflect;
/*
 * 获取成员方法并调用：
 *
 * 1.批量的：
 * 		public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
 * 		public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
 * 2.获取单个的：
 * 		public Method getMethod(String name,Class<?>... parameterTypes):
 * 					参数：
 * 						name : 方法名；
 * 						Class ... : 形参的Class类型对象
 * 		public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
 *
 * 	 调用方法：
 * 		Method --> public Object invoke(Object obj,Object... args):
 * 					参数说明：
 * 					obj : 要调用方法的对象；
 * 					args:调用方式时所传递的实参；
 */

import java.lang.reflect.Method;

public class Example4 {
    public static void main(String[] args) throws Exception{
        Class clazz=Class.forName("net.javaguides.reflect.Student");
        System.out.println("获取所有公有方法");
        for(Method m:clazz.getMethods()){
            System.out.println(m);
        }
        System.out.println("获取所有方法包括私有的(不包括继承的)");
        for(Method m:clazz.getDeclaredMethods()){
            System.out.println(m);
        }
        System.out.println("获取指定方法并调用");
        clazz.getMethod("show1", String.class).invoke(clazz.getConstructor().newInstance(), "oppo");

        Method m1=clazz.getDeclaredMethod("show4", int.class);
        m1.setAccessible(true);
        m1.invoke(clazz.getConstructor().newInstance(), 123);
    }
}
