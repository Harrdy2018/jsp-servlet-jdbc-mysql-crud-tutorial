package net.javaguides.lambda;

interface Printable{
    void print(String message);
}

public class LambdaExample2 {
    public static void main(String args[]){
        Printable printable=(x)->System.out.println(x);
        printable.print("Hello");
    }
}
