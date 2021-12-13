package net.javaguides.reflect;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

public class Example5 {
    // 通过反射运行配置文件内容
    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName(getValue("className"));
        Method m = clazz.getMethod(getValue("methodName"));
        m.invoke(clazz.getConstructor().newInstance());
    }

    public static String getValue(String key) throws Exception{
        Properties conf=new Properties();
        FileReader in = new FileReader("src/main/java/net/javaguides/reflect/conf.txt");
        conf.load(in);
        in.close();
        return conf.getProperty(key);
    }
}