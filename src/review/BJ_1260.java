package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260 {

    static int N,M,V;
    static int arr[][];
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); // 정점
        M=Integer.parseInt(st.nextToken()); // 간선
        V=Integer.parseInt(st.nextToken()); // 시작 정점

        arr=new int[N+1][N+1];
        visited=new boolean[N+1];

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            arr[x][y]=arr[y][x]=1;
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

        for(int i=1;i<N+1;i++){
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

            int now=q.poll();
            System.out.print(now+" ");

            for(int i=1;i<N+1;i++){
                if(arr[now][i]==1 && visited[i]==false){
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
    }
}
