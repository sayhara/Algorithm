package baekjoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
List<>[]와 배열을 합해서 트리를 작성한다.
양방향 그래프를 활용하여 노드를 연결한 뒤 루트노드부터 시작하여
연결된 노드를 따라가며 부모노드를 구한다.
부모 노드를 자식 노드보다 항상 먼저 방문하기 때문에
방문한 적이 없으면 현재 노드가 부모노드가 되고 연결되어 있는 노드가 자식 노드가 됨
 */

public class BJ_11725 {

    static int N;
    static int parent[];
    static boolean visited[];
    static ArrayList<Integer> list[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        parent=new int[N+1];
        visited=new boolean[N+1];
        list=new ArrayList[N+1];

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
                parent[i]=start;
                DFS(i);
            }
        }

    }
}
