package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
결국 최솟값을 구하기 위해서는 돈을 인출하는데 걸리는 시간을 낮은순으로 정렬했을때가 된다.
이를 통해 S[i]를 통해 누적합을 구해 sum을 출력한다.
 */

public class BJ_11399 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int P[]=new int[N];
        int S[]=new int[N];
        int sum=0;

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            P[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(P); // 낮은 순으로 정렬

        for(int i=0;i<N;i++){
            for(int j=0;j<=i;j++){
                S[i]+=P[j];
            }
            sum+=S[i];
        }

        System.out.println(sum);

    }
}
