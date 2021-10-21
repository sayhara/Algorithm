package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
입력으로 주어지는 값이 5분,1분,10초로 나누어지는데 순차적으로 검사를 하며 카운트하고,
 T==0일때는 모두 나누어진 경우로 count를 출력해주고, T!=0 && T<10일때는 더이상 카운트 되지 않는 경우이면서
 나누어지지 않는 경우이므로 -1을 출력한다.
 */

public class BJ_10162 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        int countA=0, countB=0, countC=0;

        while (true){

            if(T>=5*60){ // 5분
                T=T-300;
                countA++;
            } else if(T>=1*60){ // 1분
                T=T-60;
                countB++;
            } else if(T>=10){ // 10초
                T=T-10;
                countC++;
            }

            if(T==0){
                System.out.println(countA+" "+countB+" "+countC);
                break;
            }
            if(T!=0 && T<10){
                System.out.println(-1);
                break;
            }

        }
    }
}
