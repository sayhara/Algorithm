package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16943 {

    static int max=-1;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());

        String s = String.valueOf(A);
        char arr[]=new char[s.length()];

        for(int i=0;i<s.length();i++){
            arr[i]=s.charAt(i); // 순열을 위한 정수 쪼개기 작업
        }

        permutation(arr,0,arr.length,B);

        System.out.println(max);

    }

    public static void permutation(char arr[], int index, int r, int B){

        if(index==r){
            if(arr[0]!='0')
                check(arr,r,B);
            return;
        }

        for(int i=index;i<arr.length;i++){
            swap(arr,index,i);
            permutation(arr,index+1,arr.length,B);
            swap(arr,index,i);
        }

    }

    public static void swap(char arr[], int index, int i){
        char temp=arr[index];
        arr[index]=arr[i];
        arr[i]=temp;
    }

    public static void check(char arr[], int r, int B){

        String result="";

        for(int i=0;i<r;i++){
            result+=arr[i];
        }

        int value = Integer.parseInt(result);

        if(value<B){
            max=Math.max(max,value);
        }
    }
}
