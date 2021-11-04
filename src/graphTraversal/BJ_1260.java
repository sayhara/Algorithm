package graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
DFS : 깊이 우선 탐색 (스택, 혹은 재귀함수)
- 방문여부 검사 & 반복문을 통해 원하는 조건 탐색
BFS : 너비 우선 탐색 (큐)
- 방문여부 검사 & 큐에 값을 삽입, while문을 통한 전체의 조건과 값을 추출 & 반복문
 */
public class BJ_1260 {

    static int N,M,V;
    static int arr[][];
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); // 정점의 개수
        M=Integer.parseInt(st.nextToken()); // 간선의 개수
        V=Integer.parseInt(st.nextToken()); // 시작 정점
        arr=new int[N+1][N+1];

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            arr[u][v]=arr[v][u]=1;
        }

        visited=new boolean[N+1];
        DFS(V);
        System.out.println();

        visited=new boolean[N+1];
        BFS(V);
    }

    public static void DFS(int start){
        visited[start]=true;
        System.out.print(start+" ");

        for (int i=1;i<N+1;i++){
            if(arr[start][i]==1 && visited[i]==false){
                DFS(i);
            }
        }
    }

    public static void BFS(int start){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        visited[start]=true;

        while (!q.isEmpty()){
            int num=q.poll();
            System.out.print(num+" ");

            for(int i=1;i<N+1;i++){
                if(arr[num][i]==1 && visited[i]==false){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }
}
