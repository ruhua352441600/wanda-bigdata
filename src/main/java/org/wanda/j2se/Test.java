package org.wanda.j2se;

enum Color
{
    RED, GREEN, BLUE;

    // 构造函数
    private Color()
    {
        System.out.println("Constructor called for : " + this.toString());
    }

    public void colorInfo()
    {
        System.out.println("Universal Color");
    }
}

public class Test
{
    // 输出
    public static void main(String[] args)
    {
        Color c1 = Color.BLUE;
        System.out.println(c1);
        c1.colorInfo();
    }
}