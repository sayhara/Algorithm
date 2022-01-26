package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
겹쳐진 부분을 빼려고 여러 공식을 세웠는데 풀이의 오류로 계속해서 틀리게 나왔다.
솔루션은 간단하게 범위에 포함된 부분을 1로 표시해 둔 다음,
전체 색종이에서 1로 표시된 부분을 +1씩 해주면 되는 간단한 문제였다.
 */

public class BJ_2563 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        int arr[][]=new int[101][101];
        int result=0;

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            for(int j=x;j<x+10;j++){
                for(int k=y;k<y+10;k++){
                    arr[j][k]=1;
                }
            }
        }

        for(int i=1;i<101;i++){
            for(int j=1;j<101;j++){
                if(arr[i][j]==1){
                    result++;
                }
            }
        }

        System.out.println(result);

    }
}
