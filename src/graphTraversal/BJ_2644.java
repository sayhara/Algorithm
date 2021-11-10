package graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
DFS, BFS를 이용하여 부모 자식간의 관계를 따라가며 각각의 상황에서
count를 해준다.
이때, 촌수가 없는 -1의 상황을 어떻게 정의내려야 할지 고민했는데
결과가 result[]에 값이 축척되도록 하였으므로
만약 result[b]의 값이 0이면 start==b가 상황이므로 -1을 출력하도록 하였다.
DFS에서는 return문을, BFS에서는 break문을 통해 함수를 탈출하도록 정의하였다.
*/

public class BJ_2644 {

    static int N,M;
    static int a,b;
    static int arr[][];
    static boolean visited[];
    static int result[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N+1][N+1];
        visited=new boolean[N+1];
        result=new int[N+1];

        StringTokenizer st=new StringTokenizer(br.readLine());

        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());

        M=Integer.parseInt(br.readLine());

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            arr[u][v]=arr[v][u]=1;
        }

        DFS(a);
        if(result[b]==0){
            System.out.println(-1);
        } else {
            System.out.println(result[b]);
        }

    }

    public static void DFS(int start){

        visited[start]=true;

        if(start==b){
            return;
        }

        for(int i=1;i<N+1;i++){
            if(arr[start][i]==1 && visited[i]==false){
                result[i]=result[start]+1;
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

            if(now==b){
                break;
            }

            for(int i=1;i<N+1;i++){
                if(arr[now][i]==1 && visited[i]==false){
                    q.add(i);
                    visited[i]=true;
                    result[i]=result[now]+1;
                }
            }
        }
    }
}
