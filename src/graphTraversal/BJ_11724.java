package graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
양방향 간선 처리에서
처음에 모든 연결 요소를 탐색하기 위해서 이중 for문이 아닌
단일 for문의 visited[]를 이용하였다.
이후, DFS함수에서 반복문을 통해 연결됬는지 여부를 파악하였다.
 */
public class BJ_11724 {

    static int N,M;
    static int arr[][];
    static boolean visited[];
    static int count=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); // 정점의 개수
        M=Integer.parseInt(st.nextToken()); // 간선의 개수
        arr=new int[N+1][N+1];
        visited=new boolean[N+1];

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            arr[u][v]=arr[v][u]=1;
        }

        for(int i=1;i<N+1;i++){
            if(visited[i]==false){
                DFS(i);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void DFS(int start){

        visited[start]=true;

        for(int i=1;i<N+1;i++){
            if(arr[start][i]==1 && visited[i]==false){
                DFS(i);
            }
        }
    }
}
