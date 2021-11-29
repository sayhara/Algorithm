package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
정수의 특정 모양의 666과 같은 형태로 되기 위해서는
문자열의 함수를 이용하여 값을 찾는 것이 더 수월하다.
Integer.toString(또는 String.valueOf)의 함수를 이용해 문자열로 만든 후
contains 통해 특정 문자열의 모양을 검증하였다.
 */
public class BJ_1436 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int count=0;

        for(int num=666;;num++){
            if(Integer.toString(num).contains("666")){
                count++;
            }
            if(count==N){
                System.out.println(num);
                break;
            }
        }
    }
}
