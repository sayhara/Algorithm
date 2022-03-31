package baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class BJ_1057 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken()); // 김지민
        int b = Integer.parseInt(st.nextToken()); // 임한수
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        int count = 0;
        while (a<b) { // 두개의 크기 비교없이 a!=b 경우로도 가능
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            count++;
            if (a == b) {
                System.out.println(count);
                return;
            }
        }
        System.out.println(-1);
    }

}