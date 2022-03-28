package baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class BJ_10974 {

    static int N;
    static int arr[];
    static boolean visited[];
    static int output[];
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=i+1;
        }
        visited=new boolean[N];
        output=new int[N];

        permutation(0,N);
        System.out.println(sb.toString());

    }

    public static void permutation(int depth, int r){

        if(depth==r){
            for(int i=0;i<r;i++){
                sb.append(output[i]+" ");
            }
            sb.append("\n");
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                output[depth]=arr[i];
                permutation(depth+1,r);
                visited[i]=false;
            }
        }
    }
}
