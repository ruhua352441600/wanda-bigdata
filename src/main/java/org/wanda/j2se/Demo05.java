package org.wanda.j2se;

/**
 * default (即默认，什么也不写）: 在同一包内可见，不使用任何修饰符。使用对象：类、接口、变量、方法。
 *
 * private : 在同一类内可见。使用对象：变量、方法。 注意：不能修饰类（外部类）
 *
 * public : 对所有类可见。使用对象：类、接口、变量、方法
 *
 * protected : 对同一包内的类和所有子类可见。使用对象：变量、方法。 注意：不能修饰类（外部类）。
 *
 *
 * 父类中声明为 public 的方法在子类中也必须为 public。
 *
 * 父类中声明为 protected 的方法在子类中要么声明为 protected，要么声明为 public，不能声明为 private。
 *
 * 父类中声明为 private 的方法，不能够被继承。
 *
 *
 * static 修饰符，用来修饰类方法和类变量。
 *
 * final 修饰符，用来修饰类、方法和变量，final 修饰的类不能够被继承，修饰的方法不能被继承类重新定义，修饰的变量为常量，是不可修改的。
 *
 * abstract 修饰符，用来创建抽象类和抽象方法。
 *
 * synchronized 和 volatile 修饰符，主要用于线程的编程。
 */

public class Demo05 {
    private static int a;
    public static void main(String[] args) {
        System.out.println(a);
        String aa = "cxy";
        switch (aa){
            case "jzk":
                System.out.println("He is jzk");
            case "cxy":
                System.out.println("She is cxy");
            case "yz":
                System.out.println("She is cyz");
            default:
                System.out.println("NoBody");
        }
    }
}
