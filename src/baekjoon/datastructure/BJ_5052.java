package baekjoon.datastructure;

import java.util.*;
import java.io.*;

public class BJ_5052 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine()); // 테스트 케이스

        while(t-->0){
            int n=Integer.parseInt(br.readLine()); // 전화번호의 수
            String s[]=new String[n];
            String result="YES";
            for(int i=0;i<n;i++){
                s[i]=br.readLine();
            }
            Arrays.sort(s);

            for(int i=0;i<n-1;i++){
                if(s[i+1].startsWith(s[i])){
                    result="NO";
                    break;
                }
            }
            System.out.println(result);
        }
    }
}