package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
곱의 합의 최솟값을 위해서는 가장 큰 값을 가장 작은 값으로 곱함으로써 완성할 수 있다.
따라서, 하나의 배열은 오름차순 다른 하나의 배열은 내림차순으로 정렬하면 된다.
내림차순의 정렬시에는 int형이 아닌 Integer형을 이용하며, Collections.reverseOrder() 이용
 */

public class BJ_1026 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int A[]=new int[N];
        Integer B[]=new Integer[N];
        int sum=0;

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            B[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(B,Collections.reverseOrder());

        for(int i=0;i<N;i++){
            sum+=A[i]*B[i];
        }

        System.out.println(sum);

    }
}
