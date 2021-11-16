package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1012 {

    static int T,M,N,K;
    static int result[];
    static int arr[][];
    static boolean visited[][];
    static int D[][]={{-1,0},{1,0},{0,1},{0,-1}}; // 상하좌우

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        T=Integer.parseInt(br.readLine());
        result=new int[T];

        for(int i=0;i<T;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M=Integer.parseInt(st.nextToken()); // 가로길이
            N=Integer.parseInt(st.nextToken()); // 세로길이
            K=Integer.parseInt(st.nextToken()); // 위치의 개수
            arr=new int[N][M];
            visited=new boolean[N][M];

            for(int j=0;j<K;j++){
                st=new StringTokenizer(br.readLine());
                int X=Integer.parseInt(st.nextToken());
                int Y=Integer.parseInt(st.nextToken());
                arr[Y][X]=1;
            }

            int count=0;

            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(arr[j][k]==1 && visited[j][k]==false){
                        DFS(j,k);
                        count++;
                    }
                }
            }

            result[i]=count;

        }

        for(int i=0;i<T;i++){
            System.out.println(result[i]);
        }
    }

    public static void DFS(int x, int y){

        visited[x][y]=true;

        for(int i=0;i<4;i++){
            int ax=x+D[i][0];
            int ay=y+D[i][1];

            if(ax>=0 && ay>=0 && ax<N && ay<M){
                if(arr[ax][ay]==1 && visited[ax][ay]==false){
                    DFS(ax,ay);
                }
            }
        }
    }
}
