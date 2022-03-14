package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10448 {

    static int tn[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tn = new int[45];

        for (int i = 1; i < 45; i++) {
            tn[i] = i * (i + 1) / 2;
        }

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(check(num));
        }
    }

    public static int check(int start) {

        for (int i = 1; i < 45; i++) {
            for (int j = 1; j < 45; j++) {
                for (int k = 1; k < 45; k++) {
                    if (tn[i] + tn[j] + tn[k] == start) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
