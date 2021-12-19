package net.javaguides.interview;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Zhujie {
    String value();
}

@Zhujie("xxx")
class A {

}


@Zhujie("xxx")
class B {

}

public class Example4 {
    public static void main(String[] args) {
        Zhujie a1 = A.class.getAnnotation(Zhujie.class);
        System.out.println(a1);
        Zhujie b1 = B.class.getAnnotation(Zhujie.class);
        System.out.println(a1.equals(b1));
    }
}
