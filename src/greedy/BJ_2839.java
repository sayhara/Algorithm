package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
가장 적은 봉지로 만들기 위해서 5KG을 최대한 많이 사용하는 것에 중점을 두었다.
이를 위해 N을 5로 나눈 몫과 나머지를 이용하여 while문을 사용하였다.
몫에 대한 나머지를 먼저 3으로 나눠지는지 비교한 후 몫이 0일때까지 값을 감소
이에 대한 나머지가 3으로 나눠진다면 OK / 그렇지 않은 경우라면 -1을 출력
 */

public class BJ_2839 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (true) {

            int num = N / 5; // 몫
            int res = N % 5; // 나머지

            for (int i = num; i >= 0; i--) {

                if (res % 3 == 0) {
                    int result = res / 3 + i;
                    System.out.println(result);
                    return;
                }

                if (i == 0 && res % 3 != 0) {
                    System.out.println(-1);
                    return;
                }

                res += 5;

            }
        }
    }
}
