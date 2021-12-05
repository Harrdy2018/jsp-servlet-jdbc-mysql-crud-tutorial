package net.javaguides.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Example5 {
    public static void main(String[] args) {
        // collect，收集，可以说是内容最繁多、功能最丰富的部分了。从字面上去理解，就是把一个流收集起来，最终可以是收集成一个值也可以收集成一个新的集合。
        // 3.7.1 归集(toList/toSet/toMap)
        // 因为流不存储数据，那么在流中的数据完成处理后，需要将流中的数据重新归集到新的集合里。toList、toSet和toMap比较常用，另外还有toCollection、toConcurrentMap等复杂一些的用法。
        List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        List<Integer> listNew = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        Set<Integer> set = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());

        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900,12, "male", "New York"));
        personList.add(new Person("Jack", 7000, 13,"male", "Washington"));
        personList.add(new Person("Lily", 7800, 14,"female", "Washington"));
        personList.add(new Person("Anni", 8200, 25,"female", "New York"));
        personList.add(new Person("Owen", 9500, 67,"male", "New York"));
        personList.add(new Person("Alisa", 7900, 66,"female", "New York"));

        Map<?, Person> map = personList.stream().filter(p -> p.getSalary() > 8000)
                .collect(Collectors.toMap(Person::getName, p -> p));
        System.out.println("toList:" + listNew);
        System.out.println("toSet:" + set);
        System.out.println("toMap:" + map);

        /*
        3.7.2 统计(count/averaging)
        Collectors提供了一系列用于数据统计的静态方法：
        计数：count
        平均值：averagingInt、averagingLong、averagingDouble
        最值：maxBy、minBy
        求和：summingInt、summingLong、summingDouble
        统计以上所有：summarizingInt、summarizingLong、summarizingDouble
        */
        // 案例：统计员工人数、平均工资、工资总额、最高工资。
        // 求总数
        Long count = personList.stream().collect(Collectors.counting());
        // 求平均工资
        Double average = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
        // 求最高工资
        Optional<Integer> max = personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compare));
        // 求工资之和
        Integer sum = personList.stream().collect(Collectors.summingInt(Person::getSalary));
        // 一次性统计所有信息
        DoubleSummaryStatistics collect = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));

        System.out.println("员工总数：" + count);
        System.out.println("员工平均工资：" + average);
        System.out.println("员工最高工资：" + max);
        System.out.println("员工工资总和：" + sum);
        System.out.println("员工工资所有统计：" + collect);

        // 3.7.3 分组(partitioningBy/groupingBy)
        // 分区：将stream按条件分为两个Map，比如员工按薪资是否高于 8000 分为两部分。
        // 分组：将集合分为多个 Map，比如员工按性别分组。有单级分组和多级分组。
        // 案例：将员工按薪资是否高于 8000 分为两部分；将员工按性别和地区分组
        // 将员工按薪资是否高于8000分组
        Map<Boolean, List<Person>> part = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
        // 将员工按性别分组
        Map<String, List<Person>> group = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        // 将员工先按性别分组，再按地区分组
        Map<String, Map<String, List<Person>>> group2 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
        System.out.println("员工按薪资是否大于8000分组情况：" + part);
        System.out.println("员工按性别分组情况：" + group);
        System.out.println("员工按性别、地区：" + group2);

        // 3.7.4 接合(joining)
        // joining可以将 stream 中的元素用特定的连接符（没有的话，则直接连接）连接成一个字符串。
        String names = personList.stream().map(p -> p.getName()).collect(Collectors.joining(","));
        System.out.println("所有员工的姓名：" + names);
        List<String> listStr = Arrays.asList("A", "B", "C");
        String string = listStr.stream().collect(Collectors.joining("-"));
        System.out.println("拼接后的字符串：" + string);

        // 3.7.5 归约(reducing)
        // Collectors类提供的reducing方法，相比于stream本身的reduce方法，增加了对自定义归约的支持。
        // 每个员工减去起征点后的薪资之和（这个例子并不严谨，但一时没想到好的例子）
        Integer sumLast = personList.stream().collect(Collectors.reducing(0, Person::getSalary, (i, j) -> (i + j - 5000)));
        System.out.println("员工扣税薪资总和：" + sumLast);

        // stream的reduce
        Optional<Integer> sum2 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println("员工薪资总和：" + sum2.get());
    }
}
