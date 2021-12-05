package net.javaguides.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Example2 {
    public static void main(String[] args) {
        // 3.4. 聚合（max/min/count)
        // 案例一：获取String集合中最长的元素。
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串："+max.get());

        // 案例二：获取Integer集合中的最大值。
        List<Integer> list2 = Arrays.asList(7,6,9,4,11,6);
        // 自然排序
        Optional<Integer> max2=list2.stream().max(Integer::compareTo);
        // 自定义排序
        Optional<Integer> max3 = list2.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("自然排序的最大值："+max2.get());
        System.out.println("自定义排序的最大值："+max3.get());

        // 案例三：获取员工工资最高的人。
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900,12, "male", "New York"));
        personList.add(new Person("Jack", 7000, 13,"male", "Washington"));
        personList.add(new Person("Lily", 7800, 14,"female", "Washington"));
        personList.add(new Person("Anni", 8200, 25,"female", "New York"));
        personList.add(new Person("Owen", 9500, 67,"male", "New York"));
        personList.add(new Person("Alisa", 7900, 66,"female", "New York"));
        Optional<Person> list3 = personList.stream()
                .max(Comparator.comparingInt(Person::getSalary));
        System.out.println(list3.get());

        // 案例四：计算Integer集合中大于 6 的元素的个数。
        List<Integer> list4 = Arrays.asList(7,6,4,8,2,11,9);
        long count = list4.stream().filter(x->x>6).count();
        System.out.println("list中大于6的元素个数为: "+count);
    }
}
