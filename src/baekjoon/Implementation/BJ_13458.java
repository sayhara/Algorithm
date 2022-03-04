package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13458 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long count=0;

        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        int B=Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            arr[i]-=B;
            count++;
            if(arr[i]>0){
                count+=(int)Math.ceil((double)arr[i]/C);
            }
        }
        System.out.println(count);
    }
}
