package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// DP : 주어진 문제의 부분해가 전체 문제의 해를 구하는데 사용되는지를 체크

public class BJ_9095 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        int result[]=new int[T];

        for(int i=0;i<T;i++){
            int n=Integer.parseInt(br.readLine());
            result[i]=solve(n);
        }

        for(int i=0;i<T;i++){
            System.out.println(result[i]);
        }

    }

    public static int solve(int n){

        int sum[]=new int[n>3?n+1:4];
        sum[1]=1;
        sum[2]=2;
        sum[3]=4;

        for (int i = 4; i <= n; i++) {
            sum[i] = sum[i - 1] + sum[i - 2] + sum[i - 3];
        }

        return sum[n];

    }
}
