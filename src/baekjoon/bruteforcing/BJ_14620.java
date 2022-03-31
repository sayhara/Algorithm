package baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class BJ_14620 {

    static int N;
    static int arr[][];
    static boolean visited[][];
    static int dr[]={0,-1,0,1,0};
    static int dc[]={0,0,1,0,-1};
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        visited=new boolean[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        
        makeThree(0,0);
        System.out.println(min);

    }

    public static void makeThree(int cnt, int sum){

        if(cnt==3){ // 3개를 만들고 최소값과 비교
            min=Math.min(min,sum);
            return;
        }

        for(int i=1;i<N-1;i++){
            for(int j=1;j<N-1;j++){
                if(checkVisit(i,j)){ // 5군데 모두 방문하지 않은 상태
                    int res=sumFive(i,j); // 합과 동시에 방문체크
                    makeThree(cnt+1,sum+res);
                    visitDefault(i,j); // 방문여부 초기화
                }
            }
        }
    }

    public static boolean checkVisit(int r, int c){

        for(int i=0;i<5;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(visited[nr][nc]){
                return false;
            }
        }
        return true;
    }

    public static int sumFive(int r, int c){

        int sum=0;
        for(int i=0;i<5;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            visited[nr][nc]=true;
            sum+=arr[nr][nc];
        }
        return sum;
    }

    public static void visitDefault(int r, int c){

        for(int i=0;i<5;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            visited[nr][nc]=false;
        }
    }

}