package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15652 {

    static int N,M;
    static int[] output;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        output=new int[N];
        sb=new StringBuilder();

        permutation(0,0);

        System.out.println(sb);

    }

    public static void permutation(int idx, int depth){

        if(depth==M){
            for(int i=0;i<M;i++){
                sb.append(output[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=idx;i<N;i++){
            output[depth]=i+1;
            permutation(i,depth+1);
        }

    }
}
