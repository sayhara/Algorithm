package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

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
