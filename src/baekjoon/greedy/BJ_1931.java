package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
한번에 풀기 어려운 문제였다.
이차 이상의 for문을 사용하면 시간초과를 일으키기에 일차 식의 for문을 이용해야 했고,
그러기 위해서는 정렬을 이용해야 했다.
시작시간과 관계없이 종료시간을 기준으로 정렬하면 다음번의 회의 시작시간을 짧게 할 수 있고
그만큼 회의를 많이 진행할 수 있다. 만약 종료시간이 같은 경우라면 시작시간이 짧을수록 좋다.
이러한 아이디어를 위해서 2개의 매개변수 비교를 위한 Comparator를 사용하였다.
 */

public class BJ_1931 {

    static int N;
    static int arr[][];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        visited = new boolean[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) { // 종료시간을 기준으로 오름차순
                    return 1;
                } else if (o1[1] == o2[1]) { // 종료시간이 같을 경우
                    if (o1[0] > o2[0]) {
                        return 1; // 시작 시간을 기준으로 오름차순
                    }
                }
                return -1;
            }
        });

        int first = arr[0][1];
        int count = 1;

        for (int i = 1; i < N; i++) {
            if (arr[i][0] >= first) {
                first = arr[i][1];
                count++;
            }
        }

        System.out.println(count);
    }

}
