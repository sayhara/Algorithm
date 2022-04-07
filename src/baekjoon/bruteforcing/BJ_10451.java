package baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class BJ_10451 {

    static ArrayList<Integer> list[];
    static boolean visited[];
    static int result[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        result=new int[T];

        for(int i=0;i<T;i++){
            int N=Integer.parseInt(br.readLine());
            list=new ArrayList[N+1];
            visited=new boolean[N+1];

            for(int j=1;j<=N;j++){
                list[j]=new ArrayList<>();
            }
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                int num=Integer.parseInt(st.nextToken());
                list[j].add(num);
//                list[num].add(j);
            }
            int count=0;
            for(int j=1;j<=N;j++){
                if(!visited[j]){
                    dfs(j);
                    count++;
                }
            }
            result[i]=count;
        }

        for(int i=0;i<T;i++){
            System.out.println(result[i]);
        }
    }

    public static void dfs(int start){

        visited[start]=true;

        for(int x:list[start]){
            if(!visited[x]){
                dfs(x);
            }
        }
    }
}