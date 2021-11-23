package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
처음에 기준이 0또는 1이므로 이를 기준으로 뒤집을 수 있는 초기값을 설정해준다.
이후, 0->1 / 1->0일 경우 케이스를 나눠 count를 해준 후 min값을 찾는다.
 */
public class BJ_1439 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String S=br.readLine();
        String arr[]=S.split("");
        int zero=0, one=0, result=0;

        if(arr[0].equals("0")) zero++;
        else one++;

        for(int i=0;i<arr.length-1;i++){
            if(!arr[i].equals(arr[i+1])){
                if(arr[i+1].equals("0"))
                    zero++;
                else
                    one++;
            }
        }

        result=Math.min(zero,one);
        System.out.println(result);
    }
}
