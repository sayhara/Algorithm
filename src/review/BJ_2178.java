package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178 {

    static int N,M;
    static int arr[][];
    static boolean visited[][];
    static int D[][]={{-1,0},{1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        visited=new boolean[N][M];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j]=s.charAt(j)-'0'; // char -> int
            }
        }

        BFS(0,0);
    }

    public static void BFS(int x, int y){

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y]=true;

        while (!q.isEmpty()){

            int now[]=q.poll();
            int bx=now[0];
            int by=now[1];

            if(bx==N-1 && by==M-1){
                System.out.println(arr[bx][by]);
                break;
            }

            for(int i=0;i<4;i++){
                int ax=bx+D[i][0];
                int ay=by+D[i][1];

                if(ax>=0 && ay>=0 && ax<N && ay<M){
                    if(arr[ax][ay]==1 && visited[ax][ay]==false){
                        arr[ax][ay]=arr[bx][by]+1;
                        q.add(new int[]{ax,ay});
                        visited[ax][ay]=true;
                    }
                }
            }
        }
    }
}
