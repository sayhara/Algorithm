package baekjoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
일정한 count만큼 반복적으로 호출을 해주어야 하는 상황으므로
순환호출을 통해 일정 count가 되었을 때 BFS를 호출하도록 한다. (이후에는 다시 초기화)
이때, 매번 호출시마다 배열을 초기화해주어야 하므로 copy_arr[][]을 통해 검사하도록 하고,
마찬가지로 BFS()에서 q.poll()을 호출하여 제거되므로 새롭게 BFS()가 돌아가기 위해서는
값이 2일 때 q.add()를 통해 반복적으로 넣어줘야 한다.
새롭게 배열을 통해 값을 검출하므로 방문여부는 검사할 필요가 없다.
 */

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

    public static void DFS(int depth){

        if(depth==3){
            BFS();
            return;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==0){
                    arr[i][j]=1;
                    DFS(depth+1);
                    arr[i][j]=0;
                }
            }
        }
    }

    public static void BFS(){

        Queue<int[]> q=new LinkedList<>();
        int copy_arr[][] = new int[N][M];
        int count=0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                copy_arr[i][j]=arr[i][j];
                if(copy_arr[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }

        while (!q.isEmpty()){

            int now[]=q.poll();

            for(int i=0;i<4;i++){
                int ax=now[0]+D[i][0];
                int ay=now[1]+D[i][1];

                if(ax>=0 && ay>=0 && ax<N && ay<M){
                    if(copy_arr[ax][ay]==0){
                        copy_arr[ax][ay]=2;
                        q.add(new int[]{ax,ay});
                    }
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(copy_arr[i][j]==0)
                    count++;
            }
        }

        max=Math.max(max,count);

    }

}
