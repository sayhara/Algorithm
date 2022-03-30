package baekjoon.bruteforcing;

import java.io.*;
import java.util.*;

public class BJ_14503 {

    static int N, M;
    static int arr[][];
    static int dr[] = {-1, 0, 1, 0}; // 북,동,남,서
    static int dc[] = {0, 1, 0, -1};
    static int count = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);
        System.out.println(count);

    }

    public static void dfs(int r, int c, int d) {

        arr[r][c] = 9;

        for (int i = 0; i < 4; i++) { // 4방향 탐색
            d = d == 0 ? 3 : d - 1; // 왼쪽 방향
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr > 0 && nc > 0 && nr < N && nc < M) {
                if (arr[nr][nc] == 0) {
                    count++;
                    dfs(nr, nc, d);
                    return;
                }
            }
        }

        int bd = (d + 2) % 4; // 후진
        int nr = r + dr[bd];
        int nc = c + dc[bd];

        if (nr > 0 && nc > 0 && nr < N && nc < M) {
            if (arr[nr][nc] != 1) { // 후진할 수 있는 경우
                dfs(nr, nc, d); // 원래방향 유지
            }
        }
    }
}