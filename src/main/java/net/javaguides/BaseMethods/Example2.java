package net.javaguides.BaseMethods;

/**
 *  public static Integer valueOf(int i) {
 *         if (i >= IntegerCache.low && i <= IntegerCache.high)
 *             return IntegerCache.cache[i + (-IntegerCache.low)];
 *         return new Integer(i);
 *     }
 *
 *
 *   java执行 Integer a=10;的时候会去调 valueOf函数
 *   在 -128<=i<=127的时候是直接用的int原始数据类型
 *   而超过了这个范围则是new了一个对象
 *   == 在比较对象的时候是比较内存地址
 */
public class Example2 {
    public static void main(String[] args) {
        // 关于Integer大小比较问题
        Integer a=10;
        Integer b=10;
        System.out.println(a==b); // true
        System.out.println(a.equals(b)); // true

        Integer aaa=127;
        Integer bbb=127;
        System.out.println(aaa==bbb); // true
        System.out.println(aaa.equals(bbb)); // true

        Integer aaaa=128;
        Integer bbbb=128;
        System.out.println(aaaa==bbbb); // false
        System.out.println(aaaa.equals(bbbb)); // true

        Integer aa=1000;
        Integer bb=1000;
        System.out.println(aa==bb); // false
        System.out.println(aa.equals(bb)); // true

        // int 与 Integer比较大小,Integer会自动拆箱
        Integer aaaaa=128;
        int bbbbb=128;
        System.out.println(aaaaa==bbbbb); // true
        System.out.println(aaaaa.equals(bbbbb)); // true
    }
}
