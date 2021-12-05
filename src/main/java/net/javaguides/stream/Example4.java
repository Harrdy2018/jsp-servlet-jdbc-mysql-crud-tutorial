package net.javaguides.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Example4 {
    public static void main(String[] args) {
        // 3.6. 归约(reduce)
        // 归约，也称缩减，顾名思义，是把一个流缩减成一个值，能实现对集合求和、求乘积和求最值操作。
        // 案例一：求Integer集合的元素之和、乘积和最大值。
        List<Integer> list= Arrays.asList(1,3,2,8,11,4);
        // 求和方式1
        Optional<Integer> sum1=list.stream().reduce((x,y)->x+y);
        // 求和方式2
        Optional<Integer> sum2=list.stream().reduce(Integer::sum);
        // 求和方式3
        Integer sum3=list.stream().reduce(0,Integer::sum);
        // 求乘积
        Optional<Integer> product=list.stream().reduce((x,y)->x*y);
        // 求最大值方式一
        Optional<Integer> max1=list.stream().reduce((x,y)->x>y?x:y);
        // 求最大值方式2
        Integer max2 = list.stream().reduce(1, Integer::max);

        System.out.println("list求和：" + sum1.get() + "," + sum2.get() + "," + sum3);
        System.out.println("list求积：" + product.get());
        System.out.println("list求最大值：" + max1.get() + "," + max2);

        // 案例二：求所有员工的工资之和和最高工资。
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900,12, "male", "New York"));
        personList.add(new Person("Jack", 7000, 13,"male", "Washington"));
        personList.add(new Person("Lily", 7800, 14,"female", "Washington"));
        personList.add(new Person("Anni", 8200, 25,"female", "New York"));
        personList.add(new Person("Owen", 9500, 67,"male", "New York"));
        personList.add(new Person("Alisa", 7900, 66,"female", "New York"));

        // 求工资之和方式1：
        Optional<Integer> sumSalary=personList.stream().map(Person::getSalary).reduce(Integer::sum);
        // 求工资之和方式2：
        Integer sumSalary2 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(),
                (sumA, sumB) -> sumA + sumB);
        // 求工资之和方式3：
        Integer sumSalary3 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(), Integer::sum);

        // 求最高工资方式1：
        Integer maxSalary = personList.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(),
                Integer::max);
        // 求最高工资方式2：
        Integer maxSalary2 = personList.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(),
                (maxA, maxB) -> maxA > maxB ? maxA : maxB);

        System.out.println("工资之和：" + sumSalary.get() + "," + sumSalary2 + "," + sumSalary3);
        System.out.println("最高工资：" + maxSalary + "," + maxSalary2);
    }
}
