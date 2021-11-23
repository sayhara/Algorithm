package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
규칙성을 찾기 위해 로프를 사용하는 개수별 최댓값들이 어떤
특징이 있는지 알아보았다.
예를 들어
20 25 40 와 같은 경우라면,
1개 사용 -> 40 (40*1)
2개 사용 -> 50 (25*2)
3개 사용 -> 60 (20*3)
와 같이 나타나기에 배열을 오름차순으로 정렬한 후,반복문을 이용해
N-i를 곱한 뒤 이들 중 최댓값을
찾는 방법을 사용하였다.
 */

public class BJ_2217 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[N];
        int res[]=new int[N];

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int i=0;i<N;i++){
            res[i]=arr[i]*(N-i);
        }

        int max=res[0];
        for(int i=1;i<N;i++){
            if(res[i]>max){
                max=res[i];
            }
        }
        System.out.println(max);
    }
}
