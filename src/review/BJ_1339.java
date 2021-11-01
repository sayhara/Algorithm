package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1339 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[26];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[s.charAt(j)-65]+=(int)Math.pow(10,s.length()-j-1);
            }
        }

        Arrays.sort(arr);
        int sum=0;
        int value=9;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==0) continue;
            sum+=arr[i]*value;
            value--;
        }

        System.out.println(sum);

    }
}
