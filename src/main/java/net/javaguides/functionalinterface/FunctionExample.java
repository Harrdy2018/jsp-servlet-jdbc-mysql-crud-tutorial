package net.javaguides.functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionExample {
    public static List<Integer> myMath(List<Integer> list, UnaryOperator<Integer> uo){
        List<Integer> res = new ArrayList<>();
        for(Integer t: list){
            res.add(uo.apply(t));
        }
        return res;
    }

    public static List<Integer> myMathMore(List<Integer> list, UnaryOperator<Integer> uo, UnaryOperator<Integer> uo2){
        List<Integer> res = new ArrayList<>();
        for(Integer t: list){
            res.add(uo.andThen(uo2).apply(t));
        }
        return res;
    }
    public static void main(String[] args) {
        Function<String, Integer> func1 = (String str)->str.length();
        System.out.println(func1.apply("abc"));

        Function<Integer, Integer> func2 = (Integer x)->x+2;
        System.out.println(func2.apply(123));

        // 一元操作符接口
        UnaryOperator<String> func3 = str->"Hello "+str;
        System.out.println(func3.apply("world"));


        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> res = myMath(list, x->x*x);
        System.out.println(res);

        // 链式UnaryOperator
        List<Integer> res2 = myMathMore(list,
                x->x+2,
                x->x*2);
        System.out.println(res2);
    }
}
