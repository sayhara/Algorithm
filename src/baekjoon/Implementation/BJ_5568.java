package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BJ_5568 {

    static int n,k;
    static int arr[];
    static int output[];
    static boolean visited[];
    static HashSet<Integer> list=new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        k=Integer.parseInt(br.readLine());
        arr=new int[n];
        output=new int[n];
        visited=new boolean[n];

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        permutation(0,k);
        System.out.println(list.size());

    }

    public static void permutation(int index, int r){

        if(index==r){
            String result="";
            for(int i=0;i<r;i++){
                result+=output[i];
            }
            list.add(Integer.parseInt(result));
            return;
        }

        for(int i=0;i<n;i++){
            if(visited[i]==false){
                visited[i]=true;
                output[index]=arr[i];
                permutation(index+1,r);
                visited[i]=false;
            }
        }
    }
}
