package net.javaguides.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Example1 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900,12, "male", "New York"));
        personList.add(new Person("Jack", 7000, 13,"male", "Washington"));
        personList.add(new Person("Lily", 7800, 14,"female", "Washington"));
        personList.add(new Person("Anni", 8200, 25,"female", "New York"));
        personList.add(new Person("Owen", 9500, 67,"male", "New York"));
        personList.add(new Person("Alisa", 7900, 66,"female", "New York"));

        // 遍历/匹配（foreach/find/match）
        // Stream也是支持类似集合的遍历和匹配元素的，只是Stream中的元素是以Optional类型存在的。

        List<Integer> list = Arrays.asList(7,6,9,3,8,2,1);

        // 遍历输出符合条件的元素
        list.stream().filter(x->x>6).forEach(System.out::println);
        // 匹配第一个
        Optional<Integer> findFirst =list.stream().filter(x->x>6).findFirst();
        // 匹配任意(适用于并行流)
        Optional<Integer> findAny = list.parallelStream().filter(x->x>6).findAny();
        // 是否符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x->x>6);
        System.out.println("匹配第一个值："+findFirst.get());
        System.out.println("匹配任意一个值："+findAny.get());
        System.out.println("是否存在大于6的值："+anyMatch);

        // 筛选（filter）
        // 筛选大于7的元素并打印出来
        list.stream().filter(x->x>7).forEach(System.out::println);
        // 案例二：筛选员工中工资高于 8000 的人，并形成新的集合
        List<Person> filterList =personList.stream().filter(x->x.getSalary()>8000)
                .collect(Collectors.toList());
        System.out.println(filterList);
        List<String> filterNameList =personList.stream().filter(x->x.getSalary()>8000)
                .map(Person::getName).collect(Collectors.toList());
        System.out.println(filterNameList);
    }
}
