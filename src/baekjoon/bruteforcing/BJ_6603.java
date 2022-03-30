package baekjoon.bruteforcing;

import java.io.*;
import java.util.*;

public class BJ_6603 {

    static int k;
    static int arr[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            k=Integer.parseInt(st.nextToken());
            if(k==0) break;
            arr=new int[k];
            for(int i=0;i<k;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            visited=new boolean[k];
            combination(0,6);
            System.out.println();
        }
    }

    public static void combination(int depth, int r){

        if(r==0){
            for(int i=0;i<k;i++){
                if(visited[i]){
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
            return;
        }

        for(int i=depth;i<k;i++){
            if(!visited[i]){
                visited[i]=true;
                combination(i+1,r-1);
                visited[i]=false;
            }
        }
    }
}