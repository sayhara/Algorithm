package baekjoon.Implementation;

import java.io.*;
import java.util.*;

public class BJ_15683 {

    static int N,M;
    static int cnt;
    static int min = Integer.MAX_VALUE;
    static CCTV[] tv=new CCTV[8];
    static int [][] dir={{},{1},{1,3},{0,1},{0,1,3},{0,1,2,3}};
    static int [][] D={{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr=new int[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]>0 && arr[i][j]<6){
                    tv[cnt++]=new CCTV(i,j,arr[i][j]);
                }
            }
        }
        solve(0,arr);
        System.out.println(min);

    }

    static void solve(int idx, int [][] arr){

        if(idx==cnt){
            int count=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(arr[i][j]==0){
                        count++;
                    }
                }
            }
            min=Math.min(min,count);
            return;
        }

        CCTV cv=tv[idx];

        for(int d=0;d<4;d++){ // 회전
            int[][] copy_map=copy(arr);

            for(int i=0;i<dir[cv.cctv].length;i++){
                int nr=cv.r;
                int nc=cv.c;
                int nd=(dir[cv.cctv][i]-d+3)%4; // 감시하는 방향

                while (true){
                    nr+=D[nd][0];
                    nc+=D[nd][1];

                    if(!isRange(nr,nc) || arr[nr][nc]==6) break;
                    copy_map[nr][nc]=9;
                }
            }
            solve(idx+1,copy_map);
        }
    }

    static boolean isRange(int r, int c){
        return r>=0 && c>=0 && N>r && M>c;
    }

    static int[][] copy(int[][] arr){

        int[][] map=new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j]=arr[i][j];
            }
        }
        return map;
    }

    static class CCTV{
        int r;
        int c;
        int cctv;

        CCTV(int r, int c, int cctv){
            this.r=r;
            this.c=c;
            this.cctv=cctv;
        }
    }

}

