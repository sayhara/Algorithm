package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10819 {

    static int N;
    static int arr[];
    static int output[];
    static boolean visited[];
    static int max=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        output=new int[N];
        visited=new boolean[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        permutation(0);
        System.out.println(max);

    }

    public static void permutation(int depth){

        if(depth==N){
            int answer=0;
            for(int i=0;i<N-1;i++){
                answer+=Math.abs(output[i]-output[i+1]);
            }
            max=Math.max(max,answer);
            return;
        }

        for(int i=0;i<N;i++){
            if(visited[i]==false){
                visited[i]=true;
                output[depth]=arr[i];
                permutation(depth+1);
                visited[i]=false;
            }
        }
    }
}
