package baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class BJ_15661 {

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

        for(int i=1;i<N;i++){
            div(0,i);
        }
        System.out.println(min);

    }

    public static void div(int depth, int r){

        if(r==0){
            cal();
            return;
        }

        for(int i=depth;i<N;i++){
            if(!visited[i]){
               visited[i]=true;
               div(i+1,r-1);
               visited[i]=false;
            }
        }
    }

    public static void cal(){

        int startTeam=0;
        int linkTeam=0;

        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(!visited[i] && !visited[j]){
                    startTeam+=arr[i][j];
                    startTeam+=arr[j][i];
                }
                else if(visited[i] && visited[j]){
                    linkTeam+=arr[i][j];
                    linkTeam+=arr[j][i];
                }
            }
        }

        min=Math.min(min,Math.abs(startTeam-linkTeam));
    }

}
