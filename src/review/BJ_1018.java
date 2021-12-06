package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
case 1      case 2
WBWBWBWB    WBWBWBWB
BWBWBWBW    BWBWBWBW
...         ...
각각의 경우에 대해서
첫번째 케이스는 i+j의 합이 짝수인 경우의 자리에 W가 와야하는데 B가 오는 경우 -> W를 증가.
반대로  i+j의 합이 홀수인 경우에 B가 와야하는데 W가 오는 경우 경우 -> B를 증가시킴
두번째 케이스는 이의 반대로 출력하면 된다.
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

    public static void cutting(int x,int y){

        int cntB=0, cntW=0;

        for(int i=x;i<x+8;i++){
            for(int j=y;j<y+8;j++){
                if((i+j)%2==0){ // 짝수 자리
                    if(ch[i][j]=='B'){
                        cntW++;
                    } else{
                        cntB++;
                    }
                } else { // 홀수 자리
                    if(ch[i][j]=='B'){
                        cntB++;
                    } else {
                        cntW++;
                    }
                }
            }
        }

        min=Math.min(min,cntB);
        min=Math.min(min,cntW);

    }
}
