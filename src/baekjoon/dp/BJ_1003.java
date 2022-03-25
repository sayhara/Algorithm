package baekjoon.dp;

import java.io.*;

public class BJ_1003 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int s = 0; s < T; s++) {
            int n = Integer.parseInt(br.readLine());
            int[][] fibonacci = new int[n + 1][2];

            if(n==0){
                System.out.println("1 0");
                continue;
            }
            if(n==1){
                System.out.println("0 1");
                continue;
            }

            fibonacci[0][0] = 1;
            fibonacci[1][1] = 1;

            for (int i = 2; i <= n; i++) {
                fibonacci[i][0] = fibonacci[i - 1][0] + fibonacci[i - 2][0];
                fibonacci[i][1] = fibonacci[i - 1][1] + fibonacci[i - 2][1];
            }

            System.out.println(fibonacci[n][0]+" "+fibonacci[n][1]);
        }
    }
}
