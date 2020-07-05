package org.wanda.j2se;

public class Demo03 {
    //类变量
    static int allClicks = 10;

    static final double PI = 3.14;
    //实例变量
    char str;

    public int method(){
        //局部变量   必须声明和初始化值
        int a = 11;
        return a;
    }


    /**
     *
     * 数字类型的默认值为0或0.0
     * 布尔类型的默认值为false
     * 字符类型的默认值为\u0000
     * 所有引用类型的默认值为null
     *
     * static final public 等修饰符不存在先后顺序
     */
    public static void main(String[] args) {
        System.out.println(Demo03.allClicks);
        Demo03 a = new Demo03();
        System.out.println(a.str);

        System.out.println(a.method());
    }
}
