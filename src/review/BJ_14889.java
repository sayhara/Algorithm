package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백트래킹 방법 : 중복되는 경우는 탐색하지 않음
(vs DP : 모든 경우 탐색)
 */

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

        for(int i=start;i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                div(i+1,count+1);
                visited[i]=false;
            }
        }
    }

    public static void sum(){

        int start=0, link=0;
        int diff=0;

        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(visited[i]==true && visited[j]==true){
                    start+=arr[i][j];
                    start+=arr[j][i];
                } else if(visited[i]==false && visited[j]==false){
                    link+=arr[i][j];
                    link+=arr[j][i];
                }
            }
        }

        diff=Math.abs(start-link);

        min=Math.min(min,diff);
    }
}
