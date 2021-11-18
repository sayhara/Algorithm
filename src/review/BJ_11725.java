package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
트리에서 부모노드가 자식노드보다 항상 먼저 방문
 */

public class BJ_11725 {

    static int N;
    static ArrayList<Integer> list[];
    static int parent[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        N=Integer.parseInt(br.readLine()); // 노드의 개수
        list=new ArrayList[N+1];
        parent=new int[N+1];
        visited=new boolean[N+1];

        for(int i=1;i<=N;i++){
            list[i]=new ArrayList<>();
        }

        for(int i=1;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        DFS(1);
        for(int i=2;i<=N;i++){
            System.out.println(parent[i]);
        }
    }

    public static void DFS(int start){

        visited[start]=true;

        for(int i:list[start]){
            if(visited[i]==false){
                parent[i]=start; // 현재값이 연결된 값들의 부모
                DFS(i);
            }
        }
    }
}
