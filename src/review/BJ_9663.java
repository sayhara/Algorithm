package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
하나의 행에는 하나의 값만 들어갈 수 있음
 */

public class BJ_9663 {

    static int N;
    static int arr[];
    static int count=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N]; // 행에 들어갈 좌표

        nQueen(0);
        System.out.println(count);
    }

    public static void nQueen(int index) {

        if(index==N){
            count++;
            return;
        }

        for(int i=0;i<N;i++){
            arr[index]=i;
            if(possibility(index)){ // 놓을 수 있는 경우라면
                nQueen(index+1);
            }
        }
    }

    public static boolean possibility(int index) {

        for(int i=0;i<index;i++){
            if(arr[index]==arr[i]){ // 다른 행에 대해서 같은 값을 가지면 우로 만난다.
                return false;
            }
            else if(Math.abs(arr[index]-arr[i])==Math.abs(index-i)){ // 대각선의 경우 : 행의 차 = 열의 차
                return false;
            }
        }
        return true;
    }
}
