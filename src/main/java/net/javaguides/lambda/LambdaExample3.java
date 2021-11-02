package net.javaguides.lambda;

interface Addable{
    int add(int a, int b);
}

public class LambdaExample3 {
    public static void main(String args[]){
        Addable addable=(int a,int b)->{return a+b;};
        System.out.println(addable.add(1,3));
    }
}
