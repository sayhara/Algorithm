package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
처음에는 방문여부를 검사할 때 이중 for문으로 구현하려 하였다.
그렇지만 방향없는 그래프이므로 x,y의 구분이 무의미하기 때문에 방문여부를 검사하는
배열을 단일배열로 start지점으로 설정하였고 이 시작점으로부터 연결된 지점을
검사하는 방법을 적용하였다.
 */

public class BJ_11724 {

    static int N,M;
    static int arr[][];
    static boolean visited[];

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

        int count=0;

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
