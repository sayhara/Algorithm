package baekjoon.bruteforcing;

import java.io.*;
import java.util.*;

public class BJ_10971 {

    static int N;
    static int cost[][];
    static boolean visited[];
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        cost=new int[N][N];
        visited=new boolean[N];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                cost[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            visited[i]=true;
            solve(i,i,0,0);
            visited[i]=false;
        }

        System.out.println(min);

    }

    public static void solve(int start, int now, int sum, int depth){

        if(depth==N-1){
            if(cost[now][start]!=0){
                sum+=cost[now][start];
                min=Math.min(min,sum);
            }
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i] && cost[now][i]!=0){
                visited[i]=true;
                solve(start,i,sum+cost[now][i],depth+1);
                visited[i]=false;
            }
        }
    }
}