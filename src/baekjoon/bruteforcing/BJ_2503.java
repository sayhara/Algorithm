package baekjoon.bruteforcing;

import java.io.*;
import java.util.*;

public class BJ_2503 {

    static int N;
    static String num[];
    static int strike[];
    static int ball[];
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new String[N];
        strike = new int[N];
        ball = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num[i] = st.nextToken();
            strike[i] = Integer.parseInt(st.nextToken());
            ball[i] = Integer.parseInt(st.nextToken());
        }

        int arr[]={1,2,3,4,5,6,7,8,9};
        int output[]=new int[arr.length];
        boolean visited[]=new boolean[arr.length];

        permutation(arr,output,visited,0,arr.length,3);

        System.out.println(count);

    }

    public static void permutation(int[] arr, int[] output, boolean [] visited, int depth, int n, int r){

        if(depth==r){
            String result="";
            for(int i=0;i<r;i++){
                result+=output[i];
            }
            if(check(result)) count++;
        }

        for(int i=0;i<n;i++){
            if(visited[i]==false){
                visited[i]=true;
                output[depth]=arr[i];
                permutation(arr,output,visited,depth+1,n,r);
                visited[i]=false;
            }
        }
    }

    public static boolean check(String result) {

        String[] chk = result.split("");

        for (int i = 0; i < N; i++) {
            String[] chk2 = num[i].split("");
            int s = 0, b = 0;

            for (int j = 0; j < chk.length; j++) {
                if (chk[j].equals(chk2[j])) {
                    s++;
                }
            }

            for (int j = 0; j < chk.length; j++) {
                for (int k = 0; k < chk2.length; k++) {
                    if (j == k) continue;
                    if (chk[j].equals(chk2[k])) {
                        b++;
                    }
                }
            }

            if (strike[i] != s || ball[i] != b) {
                return false;
            }
        }
        return true;
    }

}
