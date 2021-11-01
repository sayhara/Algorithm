package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1744 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[N];
        boolean visited[]=new boolean[N];

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr); // 오름차순 정렬
        int sum=0;

        for(int i=0;i<arr.length-1;i=i+2){
            if(arr[i]<1 && arr[i+1]<1){
                sum+=arr[i]*arr[i+1];
                visited[i]=true;
                visited[i+1]=true;
            }
        }

        for(int i=arr.length-1;i>=1;i=i-2){
            if(arr[i]>1 && arr[i-1]>1){
                sum+=arr[i]*arr[i-1];
                visited[i]=true;
                visited[i-1]=true;
            }
        }

        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                sum+=arr[i];
            }
        }
        System.out.println(sum);
    }
}
