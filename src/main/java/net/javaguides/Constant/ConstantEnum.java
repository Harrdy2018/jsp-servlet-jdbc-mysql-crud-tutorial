package net.javaguides.Constant;
// 通过括号赋值,而且必须带有一个参构造器和一个属性跟方法，否则编译出错
// 赋值必须都赋值或都不赋值，不能一部分赋值一部分不赋值；如果不赋值则不能写构造器，赋值编译也出错
public enum ConstantEnum {
    SUNDAY("SUNDAY"),
    MONDAY("MONDAY"),
    TUESDAY("TUESDAY"),
    WEDNESDAY("WEDNESDAY"),
    THURSDAY("THURSDAY"),
    FRIDAY("FRIDAY"),
    SATURDAY("SATURDAY");

    private String value;

    private ConstantEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
