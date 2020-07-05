package org.wanda.j2se;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SearchMaxValue {
    public static void main(String[] args) {
        int[] myArray = {544,3,2,12,5,44232,23,112};
        int maxValue = 0;
        for(int i = 0;i<myArray.length;i++){
            if(myArray[i]>maxValue){
                maxValue = myArray[i];
            }
        }
        System.out.println(maxValue);

        //Arrays.sort(myArray);
        for(int v:myArray){
            System.out.println(v);
        }

        Date dateNow = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(dateNow));

        // 打印99乘法口诀
        for(int i = 1;i<=9;i++){
            for(int j = 1;j<=i;j++) {
                System.out.print(j + "*" + i + "=" + i*j + " ");
            }
            System.out.println();
        }

        // 打印三角形
        for (int i = 0; i <= 5; i++) {
            for (int j = 5; j>=i; j--){
                System.out.print(" ");
            }
            for (int k = 0;k<=i;k++){
                System.out.print("*");
            }
            for (int l= 0;l<=i-1;l++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
