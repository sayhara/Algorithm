package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2490 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int arr[][]=new int[3][4];

        for(int i=0;i<3;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<3;i++){
            int count=0;
            for(int j=0;j<4;j++){
                if(arr[i][j]==1)
                    count++;
            }
            switch (count){
                case 4:
                    System.out.println("E");
                    break;
                case 3:
                    System.out.println("A");
                    break;
                case 2:
                    System.out.println("B");
                    break;
                case 1:
                    System.out.println("C");
                    break;
                default:
                    System.out.println("D");
                    break;
            }
        }
    }
}
