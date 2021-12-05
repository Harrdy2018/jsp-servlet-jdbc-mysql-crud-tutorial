package net.javaguides.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
Stream 概述
    Java 8 是一个非常成功的版本，这个版本新增的Stream，配合同版本出现的 Lambda ，给我们操作集合（Collection）提供了极大的便利。
那么什么是Stream?
Stream将要处理的元素集合看作一种流，在流的过程中，借助Stream API对流中的元素进行操作，比如：筛选、排序、聚合等。
Stream可以由数组或集合创建，对流的操作分为两种：
    中间操作，每次返回一个新的流，可以有多个。
    终端操作，每个流只能进行一次终端操作，终端操作结束后流无法再次使用。终端操作会产生一个新的集合或值。
另外，Stream有几个特性：
    stream 不存储数据，而是按照特定的规则对数据进行计算，一般会输出结果。
    stream 不会改变数据源，通常情况下会产生一个新的集合或一个值。
    stream 具有延迟执行特性，只有调用终端操作时，中间操作才会执行。
* */
class PrintUtil {
    public void addString(String x){
        System.out.println(x+"add");
    }
}

public class CreateStream {
    public static void main(String[] args) {
        System.out.println("Create Stream!");
        // 1、通过 java.util.Collection.stream() 方法用集合创建流
        List<String> list = Arrays.asList("a", "b", "c");
        System.out.println(list);
        // 创建一个顺序流
        Stream<String> stream=list.stream();
        System.out.println(stream);
        // 创建一个并行流
        Stream<String> parallelStream=list.parallelStream();
        System.out.println(parallelStream);

        // 2、使用java.util.Arrays.stream(T[] array)方法用数组创建流
        int arr[]={1,3,5,6,8};
        IntStream intStream=Arrays.stream(arr);
        System.out.println(intStream);

        // 3、使用Stream的静态方法：of()、iterate()、generate()
        Stream<Integer> s = Stream.of(1,2,3,4,5,6);

        Stream<Integer> s2 = Stream.iterate(0,(x)->x+3).limit(4);
        s2.forEach(System.out::println);

        Stream<Double> stream3 = Stream.generate(Math::random).limit(3);
        stream3.forEach(System.out::println);

        // 扩展，如何使用 System.out::println
        List<String> strList = Arrays.asList("YangHang", "AnXiao", "LiuPeng");
        strList.forEach(new PrintUtil()::addString);
    }
}
