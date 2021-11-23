package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
비용을 최소화 하기 위해서는 리터당 가격이 싼 기름을 넣으면 된다.
따라서, 처음의 값을 세팅한 후 다음에 주유하는 기름이 싼 경우 replace를 해주고
그렇지 않은 경우 이전의 주유에서 추가적으로 더 주유를 하면 된다.
 */
public class BJ_13305 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        long road[]=new long[N-1]; // 도로의 길이
        long liter[]=new long[N]; // 리터당 가격
        long sum=0;

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<road.length;i++){
            road[i]=Long.parseLong(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<liter.length;i++){
            liter[i]=Long.parseLong(st.nextToken());
        }

        long min=liter[0];
        for(int i=0;i<N-1;i++){

            if(liter[i]<min){
                min=liter[i];
            }

            sum+=road[i]*min;

        }

        System.out.println(sum);

    }
}
