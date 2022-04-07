package baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class BJ_1303 {

    static int N,M;
    static char arr[][];
    static boolean visited[][];
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    static int count=0;
    static int sumW=0, sumB=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new char[M][N];

        for(int i=0;i<M;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j]=s.charAt(j);
            }
        }

        visited=new boolean[M][N];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]=='W' && !visited[i][j]){
                    count=0;
                    dfs(i,j,arr[i][j]);
                    sumW+=count*count;
                }
            }
        }

        visited=new boolean[M][N];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]=='B' && !visited[i][j]){
                    count=0;
                    dfs(i,j,arr[i][j]);
                    sumB+=count*count;
                }
            }
        }

        System.out.println(sumW+" "+sumB);

    }

    public static void dfs(int r, int c, char ch){

        visited[r][c]=true;
        count++;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0 && nc>=0 && nr<M && nc<N){
                if(!visited[nr][nc] && arr[nr][nc]==ch){
                    dfs(nr,nc,arr[nr][nc]);
                }
            }
        }
    }
}