package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15656 {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        int output[] = new int[N];
        sb=new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        permutation(arr, output, N, 0, M);
        System.out.println(sb);

    }

    public static void permutation(int[] arr, int[] output, int n, int depth, int r) {

        if (depth == r) {
            for(int i=0;i<r;i++){
                sb.append(output[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            output[depth] = arr[i];
            permutation(arr, output, n, depth + 1, r);
        }
    }
}
