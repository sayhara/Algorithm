package baekjoon.simulation;

import java.util.*;
import java.io.*;

public class BJ_1547 {

    static int M;
    static boolean visited[]=new boolean[4];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        M=Integer.parseInt(br.readLine());
        visited[1]=true;

        for(int i=0;i<M;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int X=Integer.parseInt(st.nextToken());
            int Y=Integer.parseInt(st.nextToken());
            swap(X,Y);
        }

        for(int i=1;i<4;i++){
            if(visited[i]){
                System.out.println(i);
            }
        }
    }

    public static void swap(int X, int Y){

        if(visited[X]){
            visited[X]=false;
            visited[Y]=true;
        }

        else if(visited[Y]){
            visited[Y]=false;
            visited[X]=true;
        }
    }
}
