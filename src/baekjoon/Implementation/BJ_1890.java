package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1890 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long dp[][] = new long[N][N]; // Memorization (움직였던 곳에서 누적으로 파악가능)
        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == N - 1 && j == N - 1) continue;
                int next = arr[i][j];
                if (next + i < N) dp[next + i][j] += dp[i][j];
                if (next + j < N) dp[i][next + j] += dp[i][j];
            }
        }
        System.out.println(dp[N - 1][N - 1]);
    }
}
