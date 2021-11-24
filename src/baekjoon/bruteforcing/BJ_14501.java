package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.youtube.com/watch?v=VEbh7lCu7Ic&t=24s
 */
public class BJ_14501 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int T[]=new int[N+1];
        int P[]=new int[N+1];
        int DP[]=new int[N+2]; // DP[i] : i일부터 퇴사일까지의 최대값

        for(int i=1;i<N+1;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            T[i]=Integer.parseInt(st.nextToken());
            P[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=N;i>0;i--){
            if(T[i]+i>N+1) {
                DP[i]=DP[i+1];  // 날짜 범위를 벗어나면 무의미
            } else {
                DP[i] = Math.max(DP[i+1],DP[i+T[i]]+P[i]);
                // DP[i+1] : 그 날의 상담을 안하고 그 다음날을 선택하였을 때
                // DP[i+T[i]] + P[i] : 그 날의  상담을 하여 해당 날짜만큼 더한 후의 그 때의 금액
            }
        }
        System.out.println(DP[1]);
    }
}
