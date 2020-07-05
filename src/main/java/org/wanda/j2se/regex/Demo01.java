package org.wanda.j2se.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo01 {
    public static void main(String[] args) {
        getPattern("I am Windows2000ABC end");
    }

    public static void isMatch(String str){
        String pattern = "(\\D*)(\\d*)(.*)";
        boolean isMatch = Pattern.matches(pattern, str);
        System.out.println("字符串中包含了'jzk'子字符串？ " + isMatch);
    }

    public static void getPattern(String str){
        List<String> strs = new ArrayList<String>();
        //String pattern = "(\\d*)(\\D*)(\\d*)";
        String pattern = "(?!Windows)";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(str);
        while(m.find()){
           strs.add(m.group());
        }
        System.out.println(strs.toString());
    }
}

