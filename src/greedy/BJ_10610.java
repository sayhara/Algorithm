package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/*
30으로 나눠 떨어지기 위해서는 각 자리수의 합이 3으로 나눠 떨어져야 하고 동시에
마지막 자리수가 0이여야 한다.
이중 가장 큰 값이 나와야 하므로 내림차순 정렬을 통하여 값을 구한다.
 */
public class BJ_10610 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String N=br.readLine();
        Integer arr[]=new Integer[N.length()];
        int sum=0;

        for(int i=0;i<N.length();i++){
            arr[i]=N.charAt(i)-'0';
            sum+=arr[i];
        }

        Arrays.sort(arr,Collections.reverseOrder());

        if(sum%3==0 && arr[N.length()-1]==0){
            for (Integer integer : arr) {
                System.out.print(integer);
            }
        } else {
            System.out.println(-1);
        }
    }
}
