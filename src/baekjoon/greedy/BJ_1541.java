package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
괄호를 이용해서 최소로 만들기 위해서는 결국 분할을 통해서 접근해야만 했다.
이용할 수 있는 부호는 +와 -이므로 이를 어떤식으로 분할해야 할까 고민하다가
마이너스(-)로 먼저 분할하고 그 분할한 덩어리들을 더하기로 분할하여 합을 구한다.
그리고 값의 최소를 계산하기 위해 처음의 값에서 나머지 덩어리들의 값을 빼주어서 구하였다.
 */

public class BJ_1541 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int first = 0, sum = 0;

        String str[] = s.split("-");

        for (int i = 0; i < str.length; i++) {
            String arr[] = str[i].split("\\+");
            if (i == 0) {
                for (int j = 0; j < arr.length; j++) {
                    first += Integer.parseInt(arr[j]);
                }
            } else {
                for (int j = 0; j < arr.length; j++) {
                    sum += Integer.parseInt(arr[j]);
                }
            }
        }

        System.out.println(first - sum);

    }
}
