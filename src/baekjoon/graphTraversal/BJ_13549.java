package baekjoon.graphTraversal;

import java.util.*;
import java.io.*;

public class BJ_13549 {

    static int N,K;
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); // 수빈
        K=Integer.parseInt(st.nextToken()); // 동생

        bfs();
        System.out.println(min);

    }

    public static void bfs(){

        Queue<Find> q=new LinkedList<>();
        boolean visited[]=new boolean[100001];
        q.add(new Find(N,0));

        while (!q.isEmpty()){

            Find now=q.poll();
            visited[now.num]=true; // 큐에서 나올때 방문처리

            if(now.num==K){
                min=Math.min(min,now.cnt);

            }
            for(int i=0;i<3;i++){

                int next=0;
                boolean check=false;
                if(i==0){
                    next=now.num+1;
                    check=true;
                } else if(i==1){
                    next=now.num-1;
                    check=true;
                } else {
                    next=now.num*2;
                }

                if(next>=0 && next<=100000 && !visited[next]){
                    if(check){
                        q.add(new Find(next, now.cnt+1));
                    } else {
                        q.add(new Find(next, now.cnt));
                    }
                }
            }
        }
    }

    public static class Find{

        int num;
        int cnt;

        public Find(int num, int cnt){
            this.num=num;
            this.cnt=cnt;
        }
    }
}