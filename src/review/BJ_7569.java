package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
범위에 대한 계산값이 있으므로 방문여부가 필요하지 않음
 */

public class BJ_7569 {

    static int M,N,H;
    static int arr[][][];
    static Queue<int[]> q=new LinkedList<>();
    static int count=0;
    static int D[][] ={{0,0,1},{0,0,-1},{0,1,0},{0,-1,0},{1,0,0},{-1,0,0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 상자의 수
        arr = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) {
                        q.add(new int[]{i, j, k});
                    }
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 1) {
                        BFS(i, j, k);
                    }
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(arr[i][j][k]==0){ // 익지 않는 토마토가 있다면
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        if(count!=0) { // 모든 토마토가 익어 있다면 마이너스를 할 필요가 없음
            count--;
        }
        System.out.println(count);

    }

    public static void BFS(int x, int y, int z){

        while (!q.isEmpty()) {

            int now[]=q.poll();
            int bx=now[0];
            int by=now[1];
            int bz=now[2];

            for(int i=0;i<6;i++){
                int ax=bx+D[i][0];
                int ay=by+D[i][1];
                int az=bz+D[i][2];

                if(ax>=0 && ay>=0 & az>=0 && ax<H && ay<N && az<M){
                    if(arr[ax][ay][az]==0){
                        arr[ax][ay][az]=arr[bx][by][bz]+1;
                        count=arr[ax][ay][az];
                        q.add(new int[]{ax,ay,az});
                    }
                }
            }
        }
    }
}
