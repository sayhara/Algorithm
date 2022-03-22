package baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

// 중복조합
public class BJ_15657 {

    static int N,M;
    static int arr[];
    static int output[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N];
        output=new int[M];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        combination(0,0);

    }

    public static void combination(int start, int depth){

        if(depth==M){
            for(int i=0;i<M;i++){
                System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=start;i<N;i++){
            output[depth]=arr[i];
            combination(i,depth+1);
        }
    }
}