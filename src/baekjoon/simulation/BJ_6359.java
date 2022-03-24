package baekjoon.simulation;

import java.util.*;
import java.io.*;

public class BJ_6359 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int n=Integer.parseInt(br.readLine());
            boolean visited[]=new boolean[n+1];

            for(int j=1;j<=n;j++){ // 배수
                for(int k=j;k<=n;k+=j){
                    if(visited[k]==false){
                        visited[k]=true;
                    } else {
                        visited[k]=false;
                    }
                }
            }
            int count=0;
            for(int j=1;j<=n;j++){
                if(visited[j]){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
