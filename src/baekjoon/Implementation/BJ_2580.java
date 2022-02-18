package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2580 {
    
    static int arr[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        arr=new int[9][9];

        for(int i=0;i<9;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        sodoku(0,0);

    }

    public static void sodoku(int r, int c){ // 2차원에 대한 백트래킹 과정은 열 먼저 증가 후 -> 행 증가

        if(c==9){
            sodoku(r+1,0);
            return;
        }

        if(r==9){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }

        if(arr[r][c]==0){
            for(int i=1;i<=9;i++){
                if(check(r,c,i)){
                    arr[r][c]=i;
                    sodoku(r,c+1);
                }
            }
            arr[r][c]=0;
            return;
        }

        sodoku(r,c+1);

    }
    
    public static boolean check(int r, int c, int value){

        for(int i=0;i<9;i++){
            if(arr[r][i]==value){
                return false;
            }
        }

        for(int i=0;i<9;i++){
            if(arr[i][c]==value){
                return false;
            }
        }

        int nr=r/3*3;
        int nc=c/3*3;

        for(int i=nr;i<nr+3;i++){
            for(int j=nc;j<nc+3;j++){
                if(arr[nr][nc]==value){
                    return false;
                }
            }
        }
        return true;
    }

}
