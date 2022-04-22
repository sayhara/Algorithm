package baekjoon.datastructure;

import java.util.*;
import java.io.*;

public class BJ_1120 {

    public static void main(String[] args) throws IOException {

        Scanner sc=new Scanner(System.in);

        String A=sc.next();
        String B=sc.next();
        int min=Integer.MAX_VALUE;
        int len=B.length()-A.length(); // 길이

        for(int i=0;i<=len;i++){
            int count=0;
            for(int j=0;j<A.length();j++){
                if(A.charAt(j)!=B.charAt(i+j)){
                    count++;
                }
            }
            min=Math.min(min,count);
        }

        System.out.println(min);

    }
}