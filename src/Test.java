import java.io.*;
import java.util.*;

// 순열 & 조합

public class Test {

    static int arr[]={1,2,3,4};
    static int n=arr.length;
    static int output[]=new int[n];
    static boolean visited[]=new boolean[n];

    public static void main(String[] args) {

        for(int i=1;i<=n;i++) {
//            permutation(output, 0, i); // 순열

        }

        for(int i=1;i<=n;i++) {
            combination(0,i); // 조합

        }

    }

    public static void permutation(int output[], int depth, int r) { // r : 뽑는 개수

        if (depth == r) {
            print_permutation(output,r);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(output,depth + 1, r);
                visited[i] = false;
            }
        }
    }

    public static void print_permutation(int output[], int r) {

        for (int i = 0; i < r; i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println();
    }

    public static void combination(int depth, int r){

        if(r==0){
            print_combination();
            return;
        }

        for(int i=depth;i<n;i++){
            if(visited[i]==false) {
                visited[i] = true;
                combination(i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

    public static void print_combination(){
        for(int i=0;i<n;i++){
            if(visited[i]){
                System.out.print(arr[i]+" ");
            }
        }
        System.out.println();
    }
}


