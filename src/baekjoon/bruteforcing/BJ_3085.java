package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3085 {

    static int N;
    static char[][] ch;
    static int max=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ch = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                ch[i][j] = s.charAt(j);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N-1;j++){
                swapCol(i,j);
                check();
                swapCol(i,j);
            }
        }

        for(int i=0;i<N-1;i++){
            for(int j=0;j<N;j++){
                swapRow(i,j);
                check();
                swapRow(i,j);
            }
        }

        System.out.println(max);
    }

    public static void swapCol(int i, int j){
        char temp;
        temp=ch[i][j];
        ch[i][j]=ch[i][j+1];
        ch[i][j+1]=temp;
    }

    public static void swapRow(int i, int j){
        char temp;
        temp=ch[i][j];
        ch[i][j]=ch[i+1][j];
        ch[i+1][j]=temp;
    }

    public static void check(){

        for(int i=0;i<N;i++){ // COL MAX
            int countCol=1;
            for(int j=0;j<N-1;j++){
                if(ch[i][j]==ch[i][j+1]){
                    countCol++;
                } else {
                    max=Math.max(max,countCol);
                    countCol=1;
                }
            }
            max=Math.max(max,countCol);
        }

        for(int i=0;i<N;i++){ // ROW MAX
            int countRow=1;
            for(int j=0;j<N-1;j++){
                if(ch[j][i]==ch[j+1][i]){
                    countRow++;
                } else {
                    max=Math.max(max,countRow);
                    countRow=1;
                }
            }
            max=Math.max(max,countRow);
        }
    }
}
