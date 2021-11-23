package baekjoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
각 높이에 따라 물에 잠기지 않는 최대크기를 구하기 위해서
count와 visited[][]를 초기화 해주었고, DFS를 통과할때마다
인접여부 및 해당 인접위치에서 높이값을 벗어나지 않는지를 검사해주었다.
 */

public class BJ_2468 {

    static int N;
    static int arr[][];
    static boolean visited[][];
    static int max = Integer.MIN_VALUE;
    static int height;
    static int D[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (height = 0; height <= 100; height++) {
            int count = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] > height && visited[i][j] == false) {
                        DFS(i, j);
                        count++;
                    }
                }
            }
            max = Math.max(max, count);
        }

        System.out.println(max);

    }

    public static void DFS(int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int dx = x + D[i][0];
            int dy = y + D[i][1];

            if (dx >= 0 && dy >= 0 && dx < N && dy < N) {
                if (visited[dx][dy] == false && arr[dx][dy] > height) {
                    visited[dx][dy] = true;
                    DFS(dx, dy);
                }
            }
        }
    }
}
