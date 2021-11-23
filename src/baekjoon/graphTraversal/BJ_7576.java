package baekjoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
최소 날짜를 출력해야 하므로 BFS를 이용하여 풀이를 하는데
이전과는 다른 방법으로 접근해야 한다.
여러 개의 토마토가 동시다발적으로 익는 상황이 발생할 수 있으므로
같은 인덱스만큼(같은 날짜만큼) 증가시키는 것이 포인트이다.
이를 위해서 하나씩 큐에 넣어서 count를 증가시키지 않고 익은 토마토를
큐에 모두 넣은 후 count를 증가시키는 방법을 사용하였다.
 */

public class BJ_7576 {

    static int M,N;
    static int arr[][];
    static boolean visited[][];
    static int D[][]={{-1,0},{1,0},{0,-1},{0,1}};
    static int result=0;
    static Queue<int[]> q=new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        M=Integer.parseInt(st.nextToken()); // 가로 칸의 수
        N=Integer.parseInt(st.nextToken()); // 세로 칸의 수
        arr=new int[N][M];
        visited=new boolean[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==1){
                    q.add(new int[]{i,j});
                }
            }
        }

        BFS();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==0){
                    System.out.println(-1);
                    return;
                }
            }
        }

        if (result==0) {
        }
        else{
            result--;
        }
        System.out.println(result);
    }

    public static void BFS(){

        while (!q.isEmpty()){
            int now[]=q.poll();
            int bx=now[0];
            int by=now[1];
            visited[bx][by]=true;

            for(int i=0;i<4;i++){
                int ax=now[0]+D[i][0];
                int ay=now[1]+D[i][1];

                if(ax>=0 && ay>=0 && ax<N && ay<M){
                    if(arr[ax][ay]==0 && visited[ax][ay]==false){
                        q.add(new int[]{ax,ay});
                        arr[ax][ay]=arr[bx][by]+1;
                        result=arr[ax][ay];
                    }
                }
            }
        }
    }
}
