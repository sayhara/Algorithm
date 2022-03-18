package baekjoon.bruteforcing;

import java.io.*;
import java.util.*;

public class BJ_1389 {

    static int N,M;
    static int arr[][];
    static boolean visited[];
    static ArrayList<Integer> list=new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); // 유저의 수
        M=Integer.parseInt(st.nextToken()); // 친구관계의 수

        arr=new int[N+1][N+1];

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            arr[A][B]=arr[B][A]=1;
        }

        for(int i=1;i<=N;i++){
            int sum=0;
            for(int j=1;j<=N;j++){
                if(i==j) continue;
                sum+=bfs(i,j);
            }
            list.add(sum);
        }

        int min=list.get(0);
        int answer=1;

        for(int i=1;i<list.size();i++){
            if(min>list.get(i)){
                min=list.get(i);
                answer=i+1;
            }
        }
        System.out.println(answer);
    }

    public static int bfs(int start, int end){

        Queue<Integer> q=new LinkedList<>();
        visited=new boolean[N+1];
        int result[]=new int[N+1];

        q.add(start);
        visited[start]=true;

        while (!q.isEmpty()){

            int now=q.poll();

            if(now==end){
                return result[now];
            }

            for(int i=1;i<=N;i++){
                if(arr[now][i]==1 && visited[i]==false){
                    visited[i]=true;
                    result[i]=result[now]+1;
                    q.add(i);
                }
            }
        }
        return 0;
    }
}
