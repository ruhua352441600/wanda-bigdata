package org.wanda.j2se;

import java.util.Scanner;

public class Demo01_Scanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext()){
            System.out.println(sc.nextLine());
        }
        sc.close();
    }
}
