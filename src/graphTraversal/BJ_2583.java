package graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
이전에도 말했다시피 x,y좌표 값으로 주어졌을 때
배열에 입력할때에는 arr[y][x]형태로 입력이 된다.
x값이 가로, y값이 세로를 의미하기 때문이다.
따라서, 이점에 먼저 유의를 하고, 인접한 것들은 같은 영역으로
분류를 하므로 D[][]를 통해 검사하여 영역을 구하면 된다.
 */

public class BJ_2583 {

    static int M,N,K;
    static int arr[][];
    static boolean visited[][];
    static int D[][]={{-1,0},{1,0},{0,-1},{0,1}};
    static ArrayList<Integer> list=new ArrayList<>();
    static int count=1;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new int[M][N];
        visited=new boolean[M][N];

        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());

            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());

            for(int j=y1;j<y2;j++){
                for(int k=x1;k<x2;k++){
                    arr[j][k]=1;
                }
            }
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]==0 && visited[i][j]==false){
                    DFS(i,j);
                    list.add(count);
                    count=1;
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }

    public static void DFS(int x,int y) {

        visited[x][y]=true;

        for(int i=0;i<4;i++){
            int ax=x+D[i][0];
            int ay=y+D[i][1];

            if(ax>=0 && ay>=0 && ax<M && ay<N){
                if(arr[ax][ay]==0 && visited[ax][ay]==false){
                    DFS(ax,ay);
                    count++;
                }
            }
        }
    }
}
