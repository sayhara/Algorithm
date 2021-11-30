package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1476 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int E=Integer.parseInt(st.nextToken());
        int S=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int e=1,s=1,m=1;
        int count=1;

        while (true){

            if(e%16==0){
                e-=15;
            }
            if(s%29==0){
                s-=28;
            }
            if(m%20==0){
                m-=19;
            }

            if(e==E && s==S && m==M){
                System.out.println(count);
                return;
            }

            e++; s++; m++;
            count++;

        }
    }
}
