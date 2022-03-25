package baekjoon.div_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2447 {

    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                star(i,j);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    public static void star(int r, int c){

        if(r<3 && c<3){
            if(r%3==1 && c%3==1){
                sb.append(" ");
            } else {
                sb.append("*");
            }
        }
        else {
            if(r%3==1 && c%3==1){
                sb.append(" ");
            } else {
                star(r/3,c/3);
            }
        }
    }

}
