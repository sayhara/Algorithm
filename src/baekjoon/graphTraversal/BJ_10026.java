package baekjoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
이전에 숫자로 했던 탐색과 달리 문자를 이용한 탐색 방법이다.
적록색약인 경우와 그렇지 않은 경우의 케이스를 나눈 후, 각각의 경우에서
같은 구역으로 COUNT할 경우 DFS()를 통해 순환을 해주면 된다.
 */

public class BJ_10026 {

    static int N;
    static int D[][]={{-1,0},{1,0},{0,-1},{0,1}};
    static char ch[][];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        ch=new char[N][N];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                ch[i][j]=s.charAt(j);
            }
        }

        int countA=0;
        int countB=0;

        visited=new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]==false){
                    dfs_normal(i,j);
                    countA++;
                }
            }
        }

        visited=new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]==false){
                    dfs_odd(i,j);
                    countB++;
                }
            }
        }

        System.out.println(countA+" "+countB);

    }

    public static void dfs_normal(int x, int y){

        visited[x][y]=true;

        for(int i=0;i<4;i++){

            int ax=x+D[i][0];
            int ay=y+D[i][1];

            if(ax>=0 && ay>=0 && ax<N && ay<N){
                if(ch[ax][ay]==ch[x][y] && visited[ax][ay]==false){
                    dfs_normal(ax,ay);
                }
            }
        }
    }

    public static void dfs_odd(int x, int y){

        visited[x][y]=true;

        for(int i=0;i<4;i++){

            int ax=x+D[i][0];
            int ay=y+D[i][1];

            if(ax>=0 && ay>=0 && ax<N && ay<N){

                if((ch[x][y]=='R' || ch[x][y]=='G') &&
                        (ch[ax][ay]=='R' || ch[ax][ay]=='G') && visited[ax][ay]==false){
                    dfs_odd(ax,ay);
                }
                else if((ch[x][y]=='B' && ch[ax][ay]=='B') && visited[ax][ay]==false){
                    dfs_odd(ax,ay);
                }
            }
        }
    }
}
