package baekjoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1707 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int K=Integer.parseInt(br.readLine());

        for(int i=0;i<K;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int V=Integer.parseInt(st.nextToken());
            int E=Integer.parseInt(st.nextToken());
            for(int j=0;j<E;j++){
                st=new StringTokenizer(br.readLine());
                int u=Integer.parseInt(st.nextToken());
                int v=Integer.parseInt(st.nextToken());
            }
        }
    }
}
