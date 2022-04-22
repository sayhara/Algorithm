package baekjoon.graphTraversal;

import java.util.*;
import java.io.*;

public class BJ_13913 {

    static int N,K;
    static boolean visited[]=new boolean[100001];
    static int parent[]=new int[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        bfs();
        int idx=K;

        Stack<Integer> stack=new Stack<>();
        while(idx!=N){
            stack.add(idx);
            idx=parent[idx];
        }
        stack.add(idx);

        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }

    }

    public static void bfs(){

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(N,0));
        visited[N]=true;

        while(!q.isEmpty()){

            Pair now=q.poll();

            if(now.num==K){
                System.out.println(now.cnt);
            }

            for(int i=0;i<3;i++){
                int next;
                if(i==0){
                    next=now.num-1;
                } else if(i==1){
                    next=now.num+1;
                } else {
                    next=now.num*2;
                }

                if(next>=0 && next<=100000 && !visited[next]){
                    visited[next]=true;
                    parent[next]=now.num;
                    q.add(new Pair(next,now.cnt+1));
                }
            }
        }
    }

    public static class Pair{

        int num;
        int cnt;

        public Pair(int num, int cnt){
            this.num=num;
            this.cnt=cnt;
        }
    }
}