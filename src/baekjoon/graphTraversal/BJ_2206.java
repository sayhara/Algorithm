package baekjoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
기존에는 BFS()를 통과한 값과
1의 값이 있는 경우 0으로 바꿔 BFS()를 통과한 뒤 값을 비교 후, 다시 1로 초기화 하는 식의
방법으로 이용했으나, 시간초과가 나타났다.
문제의 핵심은, visited의 배열을 3중 배열로 형성하여 벽의 여부를 체크하는 방법을 도입하는 것이다.
3번째의 값이 0이면 벽을 안 부순 경우, 1이면 벽을 부순 경우로 설정한 뒤, 경우의 수를 나눠
값을 도출하였다.
 */

public class BJ_2206 {

    static int N,M;
    static int arr[][];
    static boolean visited[][][];
    static int D[][]={{-1,0},{1,0},{0,1},{0,-1}};
    static int result[][];
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        visited=new boolean[N][M][2];
        result=new int[N][M];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j]=s.charAt(j)-'0';
            }
        }


        System.out.println(BFS());
    }

//    public static void change(){
//
//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                if(arr[i][j]==1){
//                    arr[i][j]=0;
//                    BFS(0,0);
//                    visited=new boolean[N][M][2];
//                    arr[i][j]=1;
//                }
//            }
//        }
//    }

    public static int BFS(){

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0,0});
        result[0][0]=1;
        visited[0][0][0]=true;

        while (!q.isEmpty()){

            int now[]=q.poll();
            int bx=now[0];
            int by=now[1];
            int wall=now[2]; // 벽을 부순 경우 : 1, 안부순 경우 : 0

            if(bx==N-1 && by==M-1){
                return result[N-1][M-1];
            }

            for(int i=0;i<4;i++){
                int ax=bx+D[i][0];
                int ay=by+D[i][1];

                if(ax>=0 && ay>=0 && ax<N && ay<M){
                    if(arr[ax][ay]==0 && visited[ax][ay][wall]==false){ // 벽이 없는 경우 그냥 이동
                        visited[ax][ay][wall]=true;
                        q.add(new int[]{ax,ay,wall});
                        result[ax][ay]=result[bx][by]+1;
                    }
                    else if(arr[ax][ay]==1 && wall==0 && visited[ax][ay][1]==false){ // 벽을 부수지 않은 상태일 경우
                        visited[ax][ay][1]=true;
                        q.add(new int[]{ax,ay,wall+1});
                        result[ax][ay]=result[bx][by]+1;
                    }
                }
            }
        }
        return -1;
    }
}
