package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1697 {

    static int N,K;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); // 수빈이의 위치
        K=Integer.parseInt(st.nextToken()); // 동생의 위치

        BFS(N);

    }

    public static void BFS(int start){

        Queue<Integer> q=new LinkedList<>();
        int result[]=new int[100001];
        boolean visited[]=new boolean[100001];
        q.add(start);
        visited[start]=true;
        int num=0;

        while (!q.isEmpty()) {

            int now=q.poll();

            for (int i = 0; i < 3; i++) {

                if (now == K) {
                    System.out.println(result[now]);
                    return;
                }

                if (i == 0) {
                    num = now - 1;
                } else if (i == 1) {
                    num = now + 1;
                } else {
                    num = now * 2;
                }

                if(num>=0 && num<result.length && visited[num]==false){
                    q.add(num);
                    visited[num]=true;
                    result[num]=result[now]+1;
                }
            }
        }
    }
}
