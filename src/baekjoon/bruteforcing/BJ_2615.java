package baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class BJ_2615 {

    static int arr[][]=new int[19][19];
    static int dr[]={1,1,0,-1};
    static int dc[]={0,1,1,1}; // 가로, 세로, 대각선

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<19;i++){
            for(int j=0;j<19;j++){
                if(arr[i][j]!=0){
                    for(int d=0;d<4;d++){
                        int cnt=bfs(i,j,d);
                        if(cnt==5){
                            System.out.println(arr[i][j]);
                            System.out.println((i+1)+" "+(j+1));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }

    public static int bfs(int r, int c, int idx){

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(r,c,1));
        int max=0;

        while(!q.isEmpty()){

            Pair now=q.poll();
            max=Math.max(max,now.cnt);

            int nr=now.r+dr[idx];
            int nc=now.c+dc[idx];

            if(nr>=0 && nc>=0 && nr<19 && nc<19){
                if(arr[now.r][now.c]==arr[nr][nc]){
                    q.add(new Pair(nr,nc, now.cnt+1));
                }
            }
        }

        if(max==5){ // 뒤쪽 체크
            int nr=r-dr[idx];
            int nc=c-dc[idx];

            if(nr>=0 && nc>=0 && nr<19 && nc<19){
                if(arr[r][c]==arr[nr][nc]){
                    max++;
                }
            }
        }
        return max;
    }

    public static class Pair{

        int r;
        int c;
        int cnt;

        public Pair(int r, int c, int cnt){
            this.r=r;
            this.c=c;
            this.cnt=cnt;
        }
    }
}