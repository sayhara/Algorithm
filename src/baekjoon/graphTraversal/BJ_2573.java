package baekjoon.graphTraversal;

import java.io.*;
import java.util.*;

public class BJ_2573 {

    static int dr[]={1,-1,0,0}; // 동서남북
    static int dc[]={0,0,-1,1};
    static int N,M;
    static int arr[][];
    static int result[][];
    static boolean check[][];
    static int time=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); // 행
        M=Integer.parseInt(st.nextToken()); // 열
        arr=new int[N][M];
        result=new int[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        while (true) {

            int count = 0;
            check = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] != 0 && !check[i][j]) { // divide test
                        dfs(i, j);
                        count++;
                    }
                }
            }

            if (count == 0) {
                System.out.println(0);
                return;
            } else if(count==1){
                bfs();
                time++;
            } else {
                System.out.println(time);
                return;
            }
        }

    }

    public static void dfs(int r, int c){

        check[r][c]=true;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0 && nc>=0 && nr<N && nc<M){
                if(check[nr][nc]==false && arr[nr][nc]!=0) {
                    dfs(nr, nc);
                }
            }
        }
    }

    public static void bfs(){

        Queue<int[]> q=new LinkedList<>();
        boolean visited[][]=new boolean[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]!=0){
                    q.add(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }

        while (!q.isEmpty()){

            int[] now = q.poll();
            int br=now[0];
            int bc=now[1];

            for(int i=0;i<4;i++){
                int nr=br+dr[i];
                int nc=bc+dc[i];

                if(nr>=0 && nc>=0 && nr<N && nc<M){
                    if(arr[nr][nc]==0 && arr[br][bc]>0 && !visited[nr][nc]){
                        result[nr][nc]=result[br][bc]+1;
                        arr[br][bc]--;
                    }
                }
            }
        }
    }
}