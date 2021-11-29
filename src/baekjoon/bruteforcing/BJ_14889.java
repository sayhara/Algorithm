package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14889 {

    static int N;
    static int arr[][];
    static boolean visited[];
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        visited=new boolean[N];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        div(0,0);
        System.out.println(min);

    }

    public static void div(int start, int count){

        if(count==N/2){
            sum();
            return;
        }

        // 탐색시간을 줄이기 위해 시작점을 i+1부터 반복을 해야
        // 중복을 배제할 수 있음
        
        for(int i=start;i<N;i++){
            if(visited[i]==false){
                visited[i]=true;
                div(i+1,count+1);
                visited[i]=false;
            }
        }
    }

    private static void sum() {

        int countA=0, countB=0;

        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(visited[i]==true && visited[j]==true){
                    countA+=arr[i][j];
                    countA+=arr[j][i];
                }
                else if(visited[i]==false && visited[j]==false){
                    countB+=arr[i][j];
                    countB+=arr[j][i];
                }
            }
        }

        int value=Math.abs(countA-countB);
        min=Math.min(min,value);
    }

}
