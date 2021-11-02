package net.javaguides.functionalinterface;

@FunctionalInterface
interface PrintableA{
    void print(String message);
}

public class CustomFunctionalInterface {
    public static void main(String[] args) {
        PrintableA printableA=(message)->System.out.println(message);
        printableA.print("Hello");
    }
}
