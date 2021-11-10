package graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1987 {

    static int R,C;
    static char arr[][];
    static boolean visited[][];
    static int D[][]={{-1,0},{1,0},{0,-1},{0,1}};
    static int result[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        arr=new char[R][C];
        visited=new boolean[R][C];
        result=new int[R*C][R*C];

        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j]=s.charAt(j);
            }
        }

        DFS(0,0);
    }

    public static void DFS(int x, int y){

        visited[x][y]=true;


        for(int i=0;i<4;i++){
            int ax=x+D[i][0];
            int ay=y+D[i][1];

            if(ax>=0 && ay>=0 && ax<R && ay<C){
                if(arr[ax][ay]!=arr[x][y] && visited[ax][ay]==false){
                    result[ax][ay]=result[x][y]+1;
                    DFS(ax,ay);
                }

                if(arr[ax][ay]==arr[x][y]){
                    System.out.println(result[ax][ay]);
                    return;
                }
            }
        }

    }
}
