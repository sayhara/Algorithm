package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
잔돈의 금액이 큰 것을 최대한으로 많이 주는 방향으로 설정하기 위해
while ~ if문을 사용
 */

public class BJ_5585 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int res=Integer.parseInt(br.readLine());
        int num=1000-res;
        int count=0;

        while(num!=0){

            if(num>=500){
                num=num-500;
                count++;
            }
            else if(num>=100){
                num=num-100;
                count++;
            }
            else if (num>=50){
                num=num-50;
                count++;
            }
            else if (num>=10){
                num=num-10;
                count++;
            }
            else if (num>=5){
                num=num-5;
                count++;
            }
            else if (num>=1){
                num=num-1;
                count++;
            }
        }

        System.out.println(count);

    }
}
