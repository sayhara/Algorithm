package baekjoon.bruteforcing;

import java.io.*;
import java.util.*;

public class BJ_15663 {

    static LinkedHashSet<String> set=new LinkedHashSet<>();

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

        for(String s:set){
            System.out.println(s);
        }

    }

    public static void permutation(int[] arr, int[] output, boolean[] visited, int N, int depth ,int r){

        if(depth==r){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<r;i++){
                sb.append(output[i]).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for(int i=0;i<N;i++){
            if(visited[i]==false){
                visited[i]=true;
                output[depth]=arr[i];
                permutation(arr,output,visited,N,depth+1,r);
                visited[i]=false;
            }
        }

    }
}
