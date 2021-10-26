package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
테스트 케이스의 경우를 아래의 예제로만 판단하면 에러를 범할 수 있다.
처음에는 값을 몫*L+나머지로만 판단했었다. 그렇게 되면 아래와 같은 상황이 나올 수 있다.
L,P,V가 차례로 5,8,15라고 한다면 결과값이 : 5+7=12가 된다.
15에서 8을 뺀 남은 7일 기간동안 모두를 휴가로 보낸다는 것은 오류다. 분명 연속하는 8일 기간 중에는
5일만 쓸 수 있다고 했는데 말이다.
따라서, 나머지의 값을 L과 비교하여 결과값을 도출하는 과정이 필요하다.
 */

public class BJ_4796 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int count=1;

        while (true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int L=Integer.parseInt(st.nextToken());
            int P=Integer.parseInt(st.nextToken());
            int V=Integer.parseInt(st.nextToken());
            if(L==0 && P==0 && V==0) break;

            int share=V/P;
            int remain=V%P;
            int value=0;

            if(remain>L){
                value=(L*share)+L;
            }

            else{
                value=(L*share)+remain;
            }

            System.out.println("Case "+count+": "+value);
            count++;
        }
    }
}
