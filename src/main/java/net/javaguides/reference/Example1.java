package net.javaguides.reference;
// <<Java编程思想>> 无论何时，对同一个对象调用hashCode()都应该生成同样的值
// Java中ArrayList存放的是值还是引用?

import java.lang.reflect.Array;
import java.util.ArrayList;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


// Java中ArrayList存放的是引用,存放基本类型的时候会转化为它的包装类
public class Example1 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayListA = new ArrayList<>();
        // System.identityHashCode()类比如C语言的地址不科学
        // 地址 0x0061FF1C 里面的值放的是 10
        int num = 10;
        arrayListA.add(num); // 实际上添加的是10的包装类的引用
        // 后来 地址 0xaabbccdd 里面的值被改成了 20
        num = 20;
        arrayListA.add(num); // 实际上添加的是20的包装类的引用
        for(Integer ss:arrayListA){
            System.out.println(ss+"  "+System.identityHashCode(ss));
        }

        User usera=new User("oppo",12);
        ArrayList<User> users=new ArrayList<>();
        users.add(usera);
        users.add(users.get(0));
        System.out.println(users);
        users.get(0).setAge(33);
        System.out.println(users);
    }
}