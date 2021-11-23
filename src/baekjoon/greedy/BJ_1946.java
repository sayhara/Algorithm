package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
1931번과 결이 비슷한 문제로, 두 개의 성적에 대한 정렬이 필요하다
그러기 위해서 하나의 값을 오름차순으로 세팅을 한 뒤, 나머지의 값을 비교를 해주면 된다.
여기서는 첫번째 값을 오름차순으로 세팅을 하였다.
만약, 정렬된 배열에서 두번째 값(면접 순위) 간의 비교시 적은 값이 나온다면
이 사람은 면접 순위는 높은 경우이므로 합격이 가능하다.
참고로, 3중 for문을 이용할수도 있었지만 그럴경우 맥시멈이 20X10만X10만이므로 시간초과를
일으킬 것이다. (1억당 약 1초)
 */

public class BJ_1946 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        int result[]=new int[T];

        for(int i=0;i<T;i++){
            int N=Integer.parseInt(br.readLine());
            int arr[][]=new int[N][2];

            for(int j=0;j<N;j++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                arr[j][0]=Integer.parseInt(st.nextToken());
                arr[j][1]=Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0]>o2[0]){ // 첫번째 항에 대해서 오름차순
                        return 1;
                    }
                    return -1;
                }
            });

            int value=arr[0][1]; // 서류심사 1등
            int count=1;
            for(int j=1;j<N;j++){
                if(value>arr[j][1]){ // 서류심사는 등수가 낮지만, 면접 등수가 높은 사람
                    value=arr[j][1];
                    count++;
                }
            }
            result[i]=count;
        }

        for(int i=0;i<T;i++){
            System.out.println(result[i]);
        }
    }
}
