package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제의 해결을 위해 A->B로 바꾸기 위해 많은 경우의 수를 고려해봤는데 답이 떠오르지 않았다.
다른 풀이를 약간 참고해보니 B로부터 A를 도출하는 아이디어를 사용하였다.
경우의 수로는 B%2==0, B%10==1, 그 외의 경우로 총 3가지를 들 수 있었다.
규칙성을 발견하기 어려울때는 역발상의 아이디어를 참고해야겠다.
 */
public class BJ_16953 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());
        int count=1;

        while (true){
            if(A==B){
                System.out.println(count);
                return;
            }
            if(A>B){
                System.out.println(-1);
                return;
            }

            if(B%2==0){
                B=B/2;
            } else if (B%10==1){
                B=B/10;
            }  else {
                System.out.println(-1);
                return;
            }
            count++;
        }

    }
}
