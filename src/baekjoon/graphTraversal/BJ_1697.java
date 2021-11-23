package baekjoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
가장 빠른 시간을 출력하는 방법이므로 BFS를 이용한다.
이때, 3가지의 방법으로 가지고 이동할 수 있는데 특별한 규칙이 없어보였다.
이에 for문을 이용해 3번을 모두 검색하면서 각각의 방법을 수행하고
3번의 count가 아닌 count를 하나씩만 증가시켰야 했다.
 */

public class BJ_1697 {

    static int N, K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        K = Integer.parseInt(st.nextToken()); // 동생의 위치

        BFS(N);

    }

    public static void BFS(int start) {

        Queue<Integer> q = new LinkedList<>();
        int arr[] = new int[100001];
        boolean visited[] = new boolean[100001];
        visited[start] = true;
        q.add(start);
        int num = 0;

        while (!q.isEmpty()) {

            int curr = q.remove();

            for (int i = 0; i < 3; i++) {

                if (i == 0) {
                    num = curr - 1;
                } else if (i == 1) {
                    num = curr + 1;
                } else {
                    num = curr * 2;
                }

                if (num >= 0 && num < arr.length && visited[num] == false) {
                    q.add(num);
                    visited[num] = true;
                    arr[num] = arr[curr] + 1;
                }

                if (curr == K) {
                    System.out.println(arr[curr]);
                    return;
                }
            }
        }
    }
}
