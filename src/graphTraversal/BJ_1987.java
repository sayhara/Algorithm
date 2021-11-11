package graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백트래킹 기법을 이용해야 하는 문제로 계속 문제가 되었던 부분은
인접한 네 칸을 탐색한 후에 해당 방문 자리를 다시 초기화 시켜줘야 된다는 것이다.
그렇게 해야만 새롭게 DFS()를 통해 탐색을 하게 되더라도
인접한 부분을 방문할 수 있기 때문이다.
즉, visited[]=true; DFS(); visited[]=false의 방법을 이용해야 한다.
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
