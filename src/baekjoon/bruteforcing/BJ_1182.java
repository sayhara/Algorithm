package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백트래킹 & 조합
https://bcp0109.tistory.com/15
 */

public class BJ_1182 {

    static int N,S;
    static int arr[];
    static boolean visited[];
    static int count=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); // 정수의 개수
        S=Integer.parseInt(st.nextToken()); // 원소의 합
        arr=new int[N];
        visited=new boolean[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            combination(0,i+1);
        }

        System.out.println(count);
    }

    // start : 시작 인덱스, r : 조합의 개수
    public static void combination(int start, int r){

        if(r==0){
            sum();
            return;
        }

        for(int i=start;i<N;i++){
            visited[i]=true;
            combination(i+1,r-1);
            visited[i]=false;
        }
    }

    public static void sum(){

        int sum=0;

        for(int i=0;i<N;i++){
            if(visited[i]){
                sum+=arr[i];
            }
        }

        if(sum==S){
            count++;
            return;
        }
    }
}
