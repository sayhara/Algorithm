package baekjoon.Implementation;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_15651 {

    static int N,M;
    static int output[];
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        output= new int[N];

        permutation(0);
        System.out.println(sb);

    }

    public static void permutation(int depth) {

        if(depth==M){
            for(int i=0;i<M;i++){
                sb.append(output[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){
            output[depth]=i+1;
            permutation(depth+1);
        }
    }

}
