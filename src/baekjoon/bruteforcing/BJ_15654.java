package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15654 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int arr[]=new int[N];
        int output[]=new int[N];
        boolean visited[]=new boolean[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        permutation(arr,output,visited,N,0,M);

    }

    public static void permutation(int[] arr, int[] output, boolean[] visited, int n, int depth, int r){

        if(depth==r){
            for(int i=0;i<r;i++){
                System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<n;i++){
            if(visited[i]==false){
                visited[i]=true;
                output[depth]=arr[i];
                permutation(arr,output,visited,n,depth+1,r);
                visited[i]=false;
            }
        }
    }
}
