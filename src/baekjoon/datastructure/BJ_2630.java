package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630 {

    static int N;
    static int arr[][];
    static int result[]=new int[2];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        div_conquer(0,0,arr.length);

        for(int i=0;i<2;i++){
            System.out.println(result[i]);
        }

    }

    public static void div_conquer(int r, int c, int len){

        boolean check=true;

        Loop:
        for(int i=r;i<r+len;i++){
            for(int j=c;j<c+len;j++){
                if(arr[r][c]!=arr[i][j]){
                    check=false;
                    break Loop;
                }
            }
        }

        if(check){
            result[arr[r][c]]++;
            return;
        }

        div_conquer(r,c,len/2);
        div_conquer(r+len/2,c,len/2);
        div_conquer(r,c+len/2,len/2);
        div_conquer(r+len/2,c+len/2,len/2);

    }
}
