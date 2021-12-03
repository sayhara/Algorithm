package baekjoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BFS를 이용할 때는 동시에 입력이 되므로
방문여부를 체크하기가 까다롭다.
DFS를 이용하자.
 */

public class BJ_1987 {

    static int R,C;
    static char arr[][];
    static int D[][]={{-1,0},{1,0},{0,-1},{0,1}};
    static int result[][];
    static boolean alpha[];
    static int max=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        arr=new char[R][C];
        result=new int[R*C][R*C];
        alpha=new boolean[26];

        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j]=s.charAt(j);
            }
        }

        DFS(0,0);

        max++;
        System.out.println(max);
    }


    public static void DFS(int x, int y){

        alpha[arr[x][y]-65]=true;

        for(int i=0;i<4;i++){
            int ax=x+D[i][0];
            int ay=y+D[i][1];

            if(ax>=0 && ay>=0 && ax<R && ay<C){

                if(alpha[arr[ax][ay]-65]==false){
                    result[ax][ay]=result[x][y]+1;
                    DFS(ax,ay);
                }
                max=Math.max(max,result[ax][ay]);
            }
        }

        alpha[arr[x][y]-65]=false;
    }
}
