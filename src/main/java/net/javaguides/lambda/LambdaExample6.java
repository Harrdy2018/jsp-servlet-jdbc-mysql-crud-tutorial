package net.javaguides.lambda;

import java.util.Comparator;
import java.util.TreeSet;

public class LambdaExample6 {
    public static void main(String[] args) {
        // 为什么使用Lambda表达式
        // 原来的匿名内部类 实现从大到小的比较器
        Comparator<Integer> comparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        };

        TreeSet<Integer> treeSet=new TreeSet<>(comparator);
        treeSet.add(123);
        treeSet.add(12);
        treeSet.add(456);
        treeSet.add(45);
        System.out.println(treeSet);

        // Lambda表达式
        Comparator<Integer> comparator1=(a,b)->Integer.compare(a,b);
        TreeSet<Integer> treeSet1=new TreeSet<>(comparator1);
    }
}
