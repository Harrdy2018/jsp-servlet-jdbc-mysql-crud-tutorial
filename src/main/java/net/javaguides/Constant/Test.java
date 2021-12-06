package net.javaguides.Constant;

public class Test {
    public static void main(String[] args) {
        System.out.println(ConstantInterface.MONDAY);

        System.out.println(ConstantEnum.MONDAY);
        System.out.println(ConstantEnum.values());
        System.out.println(ConstantEnum.valueOf("MONDAY"));
    }
}
