package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
규칙성을 파악해야 하는 문제로
발생하는 경우의 수는
case 1      case 2
WBWBWBWB    WBWBWBWB
BWBWBWBW    BWBWBWBW
....        .... 와 같다.
따라서, 해당좌표의 경우로 첫번째 케이스의
짝수의 위치에 B가 오는 경우 W를 증가 반대의 경우 B를 증가시킴
두번째 케이스의 홀수의 위치에 B가 오는 경우 B를 증가 반대의 경우 W를 증가시킨다.
 */

public class BJ_1018 {

    static int N,M;
    static char ch[][];
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        ch=new char[N][M];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                ch[i][j]=s.charAt(j);
            }
        }

        for(int i=0;i<N-7;i++){
            for(int j=0;j<M-7;j++){
                cutting(i,j);
            }
        }

        System.out.println(min);

    }

    public static void cutting(int x, int y){

        int countB=0, countW=0;

        for(int i=x;i<x+8;i++){
            for(int j=y;j<y+8;j++){
                if((i+j)%2==0){ // 짝수 자리
                   if(ch[i][j]=='B'){
                       countW++;
                   } else {
                       countB++;
                   }
                } else{ // 홀수 자리
                    if(ch[i][j]=='B'){
                        countB++;
                    } else {
                        countW++;
                    }
                }
            }
        }
        min=Math.min(min,countB);
        min=Math.min(min,countW);
    }
}
