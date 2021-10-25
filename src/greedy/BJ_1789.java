package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
int 범위 : –2,147,483,648 ~ 2,147,483,647
해당 범위를 벗어나는 정수형이므로 long타입으로 선언한다.
 */

public class BJ_1789 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());
        long sum = 0, N = 1;

        while (true) {

            sum += N;
            if (sum > S) break;
            else N++;

        }

        System.out.println(N-1);

    }
}
