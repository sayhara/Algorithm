package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1051 {

    static int result=1;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int arr[][]=new int[N][M];
        int max=Math.min(N,M);

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j]=s.charAt(j)-'0';
            }
        }
        dfs(N,M,arr,max,1);
    }

    public static void dfs(int N, int M, int arr[][], int max, int len){

        if(len==max){
            System.out.println(result);
            return;
        }

        for(int i=0;i<N-len;i++){
            for(int j=0;j<M-len;j++){
                if(arr[i][j]==arr[i+len][j] && arr[i+len][j]==arr[i][j+len]
                        && arr[i][j+len]==arr[i+len][j+len]){
                    result=Math.max(result,(len+1)*(len+1));
                }
            }
        }

        dfs(N,M,arr,max,len+1);

    }
}
