package graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
최단경로를 구하기 위해서는 BFS를 이용한다.
이때 인접하는 칸으로만 이동할 수 있으므로 상하좌우의 인덱스 1값을 검사해주어야 하며,
배열의 범위 내에 있는지도 추가로 검사해준다.
그리고 같은 레벨에서는 같은 값 만큼 증가를 시켜야하므로
(만약,오른쪽 아래쪽으로 갈 수 있다면 +2가 아닌 +1,+1로 처리해야 한다.)
이전의 배열 인덱스+1=다음 인덱스로 처리하였다.
 */
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

        for(int i=0;i<N;i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        BFS(0 ,0);
        System.out.println(arr[N-1][M-1]);

    }

    public static void BFS(int x,int y){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y]=true;

        while (!q.isEmpty()){
            int now[]=q.poll();
            int bx=now[0];
            int by=now[1];

            for(int i=0;i<4;i++){
                int ax=bx+D[i][0];
                int ay=by+D[i][1];

                if(ax>=0 && ay>=0 && ax<N && ay<M){
                    if(arr[ax][ay]==1 && visited[ax][ay]==false){
                        q.add(new int[]{ax,ay});
                        arr[ax][ay]=arr[bx][by]+1; // 같은 레벨에서는 같은 값으로 처리
                    }
                }
            }
        }
    }
}
