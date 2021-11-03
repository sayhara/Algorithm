package graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
2차원 배열을 통해 이웃하는 인접 위치의 덩어리를 count 하는 문제이다.
여기서 핵심은 가로, 세로로 주어지는 값이 2차원 배열에서는 [세로][가로]로 입력된다는 것이다.
그래서 문제를 풀다보면 일부 헷갈릴 수 있는 여지가 있으므로 주의해야 한다.
 */

public class BJ_1012 {

    static int M,N,K;
    static int arr[][];
    static boolean visited[][];
    static int D[][]={{-1,0},{1,0},{0,1},{0,-1}};
    static int count=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int result[]=new int[T];

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            K = Integer.parseInt(st.nextToken()); // 위치의 개수
            arr = new int[N][M]; // 2차원 배열에서는 [세로][가로]
            visited=new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()); // 가로
                int Y = Integer.parseInt(st.nextToken()); // 세로
                arr[Y][X] = 1;
            }

            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(arr[j][k]==1 && visited[j][k]==false){
                        DFS(j,k);
                        count++;
                    }
                }
            }
            result[i]=count;
            count=0;
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
