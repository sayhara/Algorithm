package baekjoon.graphTraversal;

import java.util.*;
import java.io.*;

public class BJ_12851 { // 중복을 허용해줘야함

    static int N,K;
    static int[] time=new int[100001];
    static int answer=Integer.MAX_VALUE;
    static int count=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        if(N>=K){
            System.out.println(N-K);
            System.out.println(1);
            return;
        }

        bfs();
        System.out.println(answer);
        System.out.println(count);

    }

    public static void bfs(){

        Queue<Integer> q=new LinkedList<>();
        q.add(N);
        time[N]=1;

        while(!q.isEmpty()){
            int now=q.poll();

            if(answer<time[now]) return;

            for(int i=0;i<3;i++){
                int next;
                if(i==0){
                    next=now-1;
                } else if(i==1){
                    next=now+1;
                } else {
                    next=now*2;
                }

                if(next<0 || next>100000) continue;

                if(next==K){
                    count++;
                    answer=time[now];
                }
                // 첫방문 OR 같은 시간에 방문 (2+2, 2*2)
                if(time[next]==0 || time[next]==time[now]+1){
                    q.add(next);
                    time[next]=time[now]+1;
                }
            }
        }
    }
}