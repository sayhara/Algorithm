package baekjoon.graphTraversal;

import java.util.*;
import java.io.*;

public class BJ_17086 {

    static int N,M;
    static int arr[][];
    static int dr[]={-1,-1,-1,1,1,1,0,0};
    static int dc[]={-1,0,1,0,1,-1,1,-1};
    static int max=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==0){
                    bfs(i,j);
                }
            }
        }

        System.out.println(max);
    }

    public static void bfs(int r, int c){

        Queue<int[]> q=new LinkedList<>();
        boolean visited[][]=new boolean[N][M];
        int result[][]=new int[N][M];
        q.add(new int[]{r,c});
        visited[r][c]=true;

        while(!q.isEmpty()){

            int[] now=q.poll();
            int br=now[0];
            int bc=now[1];

            if(arr[br][bc]==1){
                max=Math.max(max,result[br][bc]);
                return;
            }

            for(int i=0;i<8;i++){
                int nr=br+dr[i];
                int nc=bc+dc[i];

                if(nr>=0 && nc>=0 && nr<N && nc<M){
                    if(!visited[nr][nc]){
                        result[nr][nc]=result[br][bc]+1;
                        visited[nr][nc]=true;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
    }
}