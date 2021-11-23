package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_7568 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[][]=new int[N][2];
        int result[]=new int[N];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){

            int w=arr[i][0];
            int h=arr[i][1];
            int count=1;

            for(int j=0;j<N;j++){

                if(arr[j][0]>w && arr[j][1]>h){
                    count++;
                }
            }
            result[i]=count;
        }

        for(int i=0;i<N;i++){
            System.out.print(result[i]+" ");
        }
    }
}
