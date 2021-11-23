package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
처음에는 if문 다음에 System.out.println(i);를 통해
출력하였으나 계속 문제가 틀렸다고 나왔다.
이유를 살펴보니 생성자가 없는 경우에는 결과를 출력하지 못했기
때문이었다.
 */
public class BJ_2231 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int result=0;

        for(int i=1;i<=N;i++){

            int num=i;
            int sum=0;

            while(num>0){
                sum+=num%10;
                num/=10;
            }

            if(sum+i==N){
                result=i;
                break;
            }
        }
        System.out.println(result);
    }
}
