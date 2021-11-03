package net.javaguides.programs;

public class SwapTwoStrings {
    public static void main(String[] args) {
        // Java Program to Swap Two Strings With using Third Variable
        String s1="java";
        String s2="guides";
        /*
        String temp=null;
        temp=s1;
        s1=s2;
        s2=temp;
        System.out.println("s1  "+s1);
        System.out.println("s2  "+s2);
        */

        // Java Program to Swap Two Strings Without using Third Variable
        s1=s1+s2;
        s2=s1.substring(0,s1.length()-s2.length());
        s1=s1.substring(s2.length());
        System.out.println("s1  "+s1);
        System.out.println("s2  "+s2);
    }
}
