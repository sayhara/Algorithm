package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2980 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken()); // 신호등의 개수
        int L=Integer.parseInt(st.nextToken()); // 도로의 길이
        int T=0; // 신호등에 도착한 시간
        int pre=0;
        
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int D=Integer.parseInt(st.nextToken()); // 신호등의 위치
            int R=Integer.parseInt(st.nextToken()); // 빨간색
            int G=Integer.parseInt(st.nextToken()); // 초록색

            T+=D-pre;
            pre=D;

            int remain=T%(R+G);
            // 나머지가 R보다 작으면 빨간불, 크다면 초록불

            if(remain<=R){ // 빨간불 끝날때까지 기다리는 시간
                T+=R-remain;
            }
        }
        T+=L-pre; // 마지막 소요시간
        System.out.println(T);
    }
}
