package baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class BJ_5014 {

    static int F,S,G,U,D;
    static boolean visited[];
    static int result[];
    static boolean check=false;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        F=Integer.parseInt(st.nextToken()); // 총 층수
        S=Integer.parseInt(st.nextToken()); // 현재 있는 곳
        G=Integer.parseInt(st.nextToken()); // 스타트링크 (최종 목적지)
        U=Integer.parseInt(st.nextToken()); // 위로 U만큼 이동
        D=Integer.parseInt(st.nextToken()); // 아래로 D만큼 이동

        visited=new boolean[F+1];
        result=new int[F+1];

        BFS(S);
        if(!check){
            System.out.println("use the stairs");
        }

    }

    public static void BFS(int start){

        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        visited[start]=true;

        while (!q.isEmpty()){

            int now=q.poll();

            if(now==G){
                System.out.println(result[now]);
                check=true;
                return;
            }

            if(now+U<=F && visited[now+U]==false){
                visited[now+U]=true;
                result[now+U]=result[now]+1;
                q.add(now+U);
            }

            if(now-D>=1 && visited[now-D]==false){
                visited[now-D]=true;
                result[now-D]=result[now]+1;
                q.add(now-D);
            }
        }
    }
}