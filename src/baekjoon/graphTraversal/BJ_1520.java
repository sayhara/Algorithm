package baekjoon.graphTraversal;

import java.io.*;
import java.util.*;

public class BJ_1520 {

    static int M,N;
    static int arr[][];
    static int dp[][];
    static int dr[]={0,0,-1,1};
    static int dc[]={1,-1,0,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        M=Integer.parseInt(st.nextToken()); // 세로
        N=Integer.parseInt(st.nextToken()); // 가로
        arr=new int[M][N];
        dp=new int[M][N];

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                dp[i][j]=-1;
            }
        }

        System.out.println(dfs(0,0));

    }

    public static int dfs(int r, int c){

        if(r==M-1 && c==N-1){
            return 1;
        }

        if(dp[r][c]!=-1){ // 방문한 경우
            return dp[r][c];
        }
        
        dp[r][c]=0; // 방문표시

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0 && nc>=0 && nr<M && nc<N){
                if(arr[r][c]>arr[nr][nc]){
                    dp[r][c]+=dfs(nr,nc);
                }
            }
        }
        return dp[r][c];
    }
}
