package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10798 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char ch[][]=new char[5][15];

        for(int i=0;i<5;i++){ // 입력
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                ch[i][j]=s.charAt(j);
            }
        }

        for(int i=0;i<15;i++){ // 출력
            for(int j=0;j<5;j++){
                if(ch[j][i]!=0) // char null check
                    System.out.print(ch[j][i]);
            }
        }

    }
}
