package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1527 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int res = dfs(A, B, 0, 0);
        System.out.println(res);

    }

    public static int dfs(int a, int b, int value, int length){ // 1 10

        int result=0;

        if(length>=10){
            return 0;
        }

        if(value>b){
            return 0;
        }

        if(value>=a){
            result++;
        }

        result+=dfs(a,b,value*10+4,length+1)
                +dfs(a,b,value*10+7,length+1);

        return result;
    }
}
