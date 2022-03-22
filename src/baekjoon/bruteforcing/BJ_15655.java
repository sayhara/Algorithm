package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15655 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int arr[]=new int[N];
        boolean visited[]=new boolean[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        combination(arr,visited, N,0,M);

    }

    public static void combination(int arr[], boolean visited[], int n, int depth, int r){

        if(r==0){
            for(int i=0;i<n;i++){
                if(visited[i]){
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
            return;
        }

        for(int i=depth;i<n;i++){
            if(visited[i]==false){
                visited[i]=true;
                combination(arr,visited,n,i+1,r-1);
                visited[i]=false;
            }
        }
    }
}
