package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14501 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int T[]=new int[N+1];
        int P[]=new int[N+1];
        int DP[]=new int[N+2]; // 해당 날부터 퇴사일까지의 최대

        for(int i=1;i<N+1;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            T[i]=Integer.parseInt(st.nextToken());
            P[i]=Integer.parseInt(st.nextToken());
        }

        // DP[day]=max(DP[day+1], DP[day]+T[day]]+P[day])

        for(int i=N;i>0;i--){ // 뒤에서부터 탐색을 해야 DP에 미리 값이 들어감
            if(i+T[i]>N+1){
                DP[i]=DP[i+1];
            } else {
                DP[i]=Math.max(DP[i+1],DP[i+T[i]]+P[i]);
            }
        }

        System.out.println(DP[1]);
    }
}
