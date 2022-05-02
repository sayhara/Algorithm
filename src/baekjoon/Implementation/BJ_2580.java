package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.*;
import java.io.*;

public class BJ_2580 {

    static int arr[][]=new int[9][9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<9;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0,0);

    }

    public static void sudoku(int row, int col){

        if(col==9){
            sudoku(row+1,0);
            return;
        }

        if(row==9){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if(arr[row][col]==0){
            for(int i=1;i<=9;i++){
                if(check(row,col,i)){
                    arr[row][col]=i;
                    sudoku(row,col+1);
                }
            }
            arr[row][col]=0;
            return;
        }
        sudoku(row,col+1);
    }

    public static boolean check(int row, int col, int num){

        for(int i=0;i<9;i++){
            if(arr[row][i]==num){
                return false;
            }
        }

        for(int i=0;i<9;i++){
            if(arr[i][col]==num){
                return false;
            }
        }

        int nr=row/3*3;
        int nc=col/3*3;

        for(int i=nr;i<nr+3;i++){
            for(int j=nc;j<nc+3;j++){
                if(arr[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }
}