package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2447 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        star(N);
    }

    public static void star(int N){

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.println();
            }
        }



    }


}
