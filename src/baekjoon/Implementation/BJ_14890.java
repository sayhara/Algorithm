package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14890 {

    static int N,L;
    static int arr[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        int value = 0;

        for(int i=0;i<N;i++){
            if(check(i,0,true)) // 행
                value++;
            if(check(0,i,false)) // 열
                value++;
        }

        System.out.println(value);

    }

    public static boolean check(int x,int y,boolean flag){

        int[] height=new int[N];
        boolean[] visited=new boolean[N];

        for(int i=0;i<N;i++){
            if(flag)
                height[i]=arr[x][i]; // 행 검사
            else
                height[i]=arr[i][y]; // 열 검사
        }

        for(int i=0;i<N-1;i++){
            int first=height[i];
            int second=height[i+1];

            if(first==second){
                continue;
            }
            // 내려갈 때
            else if(first-second==1){
                for(int j=i+1;j<=i+L;j++){
                    if(height[i+1]!=height[j]){
                        return false;
                    }
                    visited[j]=true;
                }
            }
            // 올라갈 때
            else if(first-second==-1){
                for(int j=i;j>i-L;j--){
                    if(height[i]!=height[j]){
                        return false;
                    }
                    visited[j]=true;
                }
            }

            // 높이가 2이상 차이
            else {
                return false;
            }

        }
        return true;
    }
}
