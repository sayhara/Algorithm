package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14502 {

    static int N,M;
    static int arr[][];
    static int D[][]={{-1,0},{1,0},{0,1},{0,-1}};
    static int max=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); // 세로 크기
        M=Integer.parseInt(st.nextToken()); // 가로 크기
        arr=new int[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        DFS(0);
        System.out.println(max);

    }

    public static void DFS(int start){

        if(start==3){
            BFS();
            return;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==0){
                    arr[i][j]=1;
                    DFS(start+1);
                    arr[i][j]=0;
                }
            }
        }
    }

    public static void BFS(){

        Queue<int[]> q=new LinkedList<>();
        int copy_arr[][]=new int[N][M];
        int count=0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==2){
                    q.add(new int[]{i,j});
                }
                copy_arr[i][j]=arr[i][j];
            }
        }

        while (!q.isEmpty()){
            int now[]=q.poll();
            int bx=now[0];
            int by=now[1];

            for(int i=0;i<4;i++){
                int ax=bx+D[i][0];
                int ay=by+D[i][1];

                if(ax>=0 && ay>=0 && ax<N && ay<M){
                    if(copy_arr[ax][ay]==0){
                        copy_arr[ax][ay]=2;
                        q.add(new int[]{ax,ay});
                    }
                }
            }
        }

        for(int i=0;i<N;i++) {
            for (int j = 0; j < M; j++) {
                if (copy_arr[i][j] == 0) {
                    count++;
                }
            }
        }
        max=Math.max(max,count);
    }
}
