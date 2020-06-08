package org.wanda.string;

public class StringReverse {
    public  static void main(String[] args){
        String str = "abcd";
        System.out.println(reverseString(str));

        System.out.println(new StringBuilder(str).reverse().toString());
        System.out.println(reverse3(str));
    }

    public static String reverseString(String str){
        char[] chars = str.toCharArray();
        String ss = "";
        for(int i = 0; i<chars.length; i++){
            ss = chars[i] + ss;
        }
        return ss;
    }

    public static String reverse3(String str) {
        String reverse = "";
        int length = str.length();
        for (int i = 0; i < length; i++) {
            reverse = str.charAt(i) + reverse;
        }
        return reverse;
    }

}


