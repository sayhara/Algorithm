package graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
Not Solve
 */

public class BJ_2206 {

    static int N,M;
    static int arr[][];
    static boolean visited[][];
    static int D[][]={{-1,0},{1,0},{0,1},{0,-1}};
    static int result[][];
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        visited=new boolean[N][M];
        result=new int[N][M];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j]=s.charAt(j)-'0';
            }
        }

        BFS(0,0);
        change();

        if(result[N-1][M-1]>0){
            min++;
            System.out.println(min);
        } else{
            System.out.println(-1);
        }
    }

    public static void change(){

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==1){
                    arr[i][j]=0;
                    BFS(0,0);
                    visited=new boolean[N][M];
                    arr[i][j]=1;
                }
            }
        }
    }

    public static void BFS(int x,int y){

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y]=true;

        while (!q.isEmpty()){

            int now[]=q.poll();
            int bx=now[0];
            int by=now[1];

            if(N==1 && M==1){
                if(arr[0][0]==0) {
                    System.out.println(1);
                } else {
                    System.out.println(-1);
                }
                return;
            }

            if(bx==N-1 && by==M-1){
                min=Math.min(min,result[bx][by]);
                return;
            }

            for(int i=0;i<4;i++){
                int ax=bx+D[i][0];
                int ay=by+D[i][1];

                if(ax>=0 && ay>=0 && ax<N && ay<M){
                    if(arr[ax][ay]==0 && visited[ax][ay]==false){
                        q.add(new int[]{ax,ay});
                        visited[ax][ay]=true;
                        result[ax][ay]=result[bx][by]+1;
                    }
                }
            }
        }
    }
}
