package org.wanda.j2se;

//数据类型   基本类型/引用类型
/**
 * 基本数据类型
 * 1字节  8bit(位)
 * byte 1字节   -2^7 ~ 2^7-1    -128~127
 * shot 2字节   -2^15 ~ 2^15-1  -32768 ~ 32767
 * int  4字节   -2^31 ~ 2^31-1  -2147483648 ~ 2147483647
 * long 8字节   -2^63 ~ 2^63-1  -9223372036854775808 ~ 9223372036854775807
 *
 * float  4字节     舍入误差   接近但不等于
 * double 8字节
 *
 * char   2字节
 *
 * boolean 1bit
 *
 *
 * 引用数据类型   类/
 */

public class Demo02 {
    public static void main(String[] args) {
        //强数据类型语言，类型不匹配将报错
        String a = "00";

        short i = -32768;
        Long j = 101L;

        float m = 0.44F;
        double n = 0.55;
        char o = 'A';


        //整数进制   二进制  十进制  八进制  十六进制
        System.out.println(10);
        System.out.println(010);
        System.out.println(0xA6);
        System.out.println();


    }
}
