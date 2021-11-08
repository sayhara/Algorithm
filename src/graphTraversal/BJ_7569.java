package graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
간과했던 오류로는 익은 토마토가 여러개가 있을 수 있다는 것이다.
즉, BFS를 통해 검색을 할 때 하나씩 큐에 넣지 말고 미리 큐에 익은 토마토를
모두 가지고 있어야한다. 그래야만 같은 시간에 COUNT를 할 수 있다.
따라서, 처음에 입력하는 시점에 배열의 값이 1이면 익은 경우이므로
큐에 삽입하여 BFS()를 통과하도록 한다.
이런식으로 할 경우, BFS에 매개변수가 없어도 가능하다.
큐를 통해 poll()만 해주면 검색이 가능하기 때문이다.
 */

public class BJ_7569 {

    static int M, N, H;
    static int arr[][][];
    static int D[][] = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
    static boolean visited[][][];
    static Queue<int[]> q = new LinkedList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로 칸의 수
        N = Integer.parseInt(st.nextToken()); // 세로 칸의 수
        H = Integer.parseInt(st.nextToken()); // 높이의 수
        arr = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k]==1){
                        q.add(new int[]{i,j,k});
                    }
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 1 && visited[i][j][k] == false) {
                        BFS(i, j, k);
                    }
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        if (result != 0) {
            result--;
        }
        System.out.println(result);
    }

    public static void BFS(int x, int y, int z) {

        visited[x][y][z] = true;

        while (!q.isEmpty()) {

            int now[] = q.poll();
            int bx = now[0];
            int by = now[1];
            int bz = now[2];

            for (int i = 0; i < 6; i++) {
                int dx = bx + D[i][0];
                int dy = by + D[i][1];
                int dz = bz + D[i][2];

                if (dx >= 0 && dy >= 0 && dz >= 0 && dx < H && dy < N && dz < M) {
                    if (arr[dx][dy][dz] == 0 && visited[dx][dy][dz] == false) {
                        q.add(new int[]{dx, dy, dz});
                        arr[dx][dy][dz] = arr[bx][by][bz] + 1;
                        result = arr[dx][dy][dz];
                    }
                }
            }
        }
    }
}
