package net.javaguides.lambda;

interface Drawable{
    void draw();
}

class DrawbleImpl implements Drawable{

    @Override
    public void draw() {
        System.out.println("drawing...");
    }
}

public class LambdaExample1 {
    public static void  main(String argv[]){
        /*
        Drawable drawable=new DrawbleImpl();
        drawable.draw();
        */

        /*
        Drawable drawable=new Drawable() {
            @Override
            public void draw() {
                System.out.println("drawing...");
            }
        };
        drawable.draw();
        */

        // use a lambda exprssion to implement of function interface
        Drawable drawable=()->System.out.println("drawing...");
        drawable.draw();
    }
}
