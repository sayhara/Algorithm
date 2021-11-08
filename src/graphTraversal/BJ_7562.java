package graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
최소 이동횟수를 구하기 위해서 BFS를 이용하였고,
시작점과 도착점이 명확하므로 break 지점을 설정하기가 가능하다.
list를 이용하여 값을 삽입 후 마지막에 배열의 요소들을 한번에 출력하였다.
*/
public class BJ_7562 {

    static int T, l;
    static int arr[][];
    static int x1, x2, y1, y2;
    static int D[][] = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    static boolean visited[][];
    static ArrayList list = new ArrayList();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            l = Integer.parseInt(br.readLine()); // 한변의 길이
            arr = new int[l][l];
            visited = new boolean[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st2.nextToken());
            y2 = Integer.parseInt(st2.nextToken());

            BFS(x1, y1);
        }

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }

    public static void BFS(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {

            int now[] = q.poll();
            int bx = now[0];
            int by = now[1];

            if (bx == x2 && by == y2) {
                list.add(arr[bx][by]);
                break;
            }

            for (int i = 0; i < 8; i++) {
                int ax = bx + D[i][0];
                int ay = by + D[i][1];

                if (ax >= 0 && ay >= 0 && ax < l && ay < l) {
                    if (arr[ax][ay] == 0 && visited[ax][ay] == false) {
                        arr[ax][ay] = arr[bx][by] + 1;
                        q.add(new int[]{ax, ay});
                    }
                }
            }
        }
    }
}
