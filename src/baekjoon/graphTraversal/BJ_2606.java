package baekjoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
연결된 두 선은 배열을 통해 값을 1로 세팅한 후,
DFS(또는 BFS)를 통해 연결됬는지와 방문여부 체크를 하여 count를 계산할 수 있다.
 */
public class BJ_2606 {

    static int N,M;
    static int arr[][];
    static boolean visited[];
    static int count=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        M=Integer.parseInt(br.readLine());
        arr=new int[N+1][N+1];
        visited=new boolean[N+1];

        for(int i=0;i<M;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            arr[u][v]=arr[v][u]=1;
        }

        DFS(1);
        System.out.println(count);

    }

    public static void DFS(int start){
        visited[start]=true;

        for(int i=1;i<N+1;i++){
            if(arr[start][i]==1 && visited[i]==false) {
                DFS(i);
                count++;
            }
        }
    }
}

// 방법 2 : union-find

/*

import java.util.*;
import java.io.*;

public class Main {

    static int parent[];
    static int n,m;
    static int count=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());
        parent=new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i]=i;
        }

        for(int i=0;i<m;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            union(x,y);
        }

        for(int i=2;i<=n;i++){
            if(find(1)==find(i)){
                count++;
            }
        }

        System.out.println(count); // 자기자신 제외

    }

    public static void union(int x, int y){

        x=find(x);
        y=find(y);
        if(x<y){
            parent[y]=x;
        } else {
            parent[x]=y;
        }

    }


    public static int find(int child){

        if(child==parent[child]){
            return child;
        }
        return parent[child]=find(parent[child]);
    }
}

 */