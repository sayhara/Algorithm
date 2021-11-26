package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14888 {

    static int N;
    static int arr[],rule[];
    static int max=Integer.MIN_VALUE;
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        rule=new int[4];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            rule[i]=Integer.parseInt(st.nextToken());
        }

        cycle(arr[0],1);

        System.out.println(max);
        System.out.println(min);

    }

    public static void cycle(int num, int idx){

        if(idx==N){
            max=Math.max(max,num);
            min=Math.min(min,num);
            return;
        }

        for(int i=0;i<4;i++){
            if(rule[i]>0){
                rule[i]--;
                switch (i) {
                    case 0:
                        cycle(num + arr[idx], idx + 1);
                        break;
                    case 1:
                        cycle(num - arr[idx], idx + 1);
                        break;
                    case 2:
                        cycle(num * arr[idx], idx + 1);
                        break;
                    case 3:
                        cycle(num / arr[idx], idx + 1);
                        break;
                }
                rule[i]++; // 백트래킹을 위한 다시 복원과정
            }
        }
    }
}
