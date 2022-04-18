package baekjoon.graphTraversal;

import java.util.*;
import java.io.*;

public class BJ_13913 {

    static int N,K;
    static int parent[]=new int[100001];
    static int visited[]=new int[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        find();
        System.out.println(visited[K]-1);

        Stack<Integer> stack=new Stack<>();
        int idx=K;
        while(idx!=N){
            stack.add(idx);
            idx=parent[idx];
        }
        stack.add(idx);

        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    public static void find(){

        Queue<Integer> q=new LinkedList<>();
        visited[N]=1;
        q.add(N);

        while(!q.isEmpty()){

            int now=q.poll();
            int next;
            for(int i=0;i<3;i++){

                if(visited[K]!=0){
                    return;
                }

                if(i==0){
                    next=now-1;
                } else if(i==1){
                    next=now+1;
                } else {
                    next=now*2;
                }

                if(next>=0 && next<100001 && visited[next]==0){
                    visited[next]=visited[now]+1;
                    parent[next]=now;
                    q.add(next);
                }
            }
        }
    }
}