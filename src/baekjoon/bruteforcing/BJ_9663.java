package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
n=1,2,3,... 생각
-> 하나의 행에 하나의 퀸만 들어간다.
 */

public class BJ_9663 {

    static int N;
    static int arr[]; // 행에 들어갈 좌표들
    static int count=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N];

        nQueen(0);
        System.out.println(count);

    }

    public static void nQueen(int depth){

        if(depth==N){
            count++;
            return;
        }

        for(int i=0;i<N;i++){
            arr[depth]=i;
            if(Possibility(depth)){
                nQueen(depth+1);
            }
        }
    }

    public static boolean Possibility(int col){

        for(int i=0;i<col;i++){
            if(arr[col]==arr[i]){ // 같은 행에 존재할 경우
                return false;
            }
            else if(Math.abs(col-i)==Math.abs(arr[col]-arr[i])){ // 대각선 (열의 차 = 행의 차)
                return false;
            }
        }
        return true;
    }

}
