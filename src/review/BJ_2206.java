package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2206 {

    static int N,M;
    static int arr[][];
    static int result[][];
    static boolean visited[][][];
    static int D[][]={{-1,0},{1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        result=new int[N][M];
        visited=new boolean[N][M][2];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j]=s.charAt(j)-'0';
            }
        }

        BFS();

    }

    public static void BFS(){

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0,0}); // 세번째 값 : 0 -> 벽을 안 부순 경우, 1 -> 벽을 부순 경우
        result[0][0]=1;
        visited[0][0][0]=true;

        while (!q.isEmpty()){
            int now[]=q.poll();
            int bx=now[0];
            int by=now[1];
            int wall=now[2];

            if(bx==N-1 && by==M-1){
                System.out.println(result[bx][by]);
                return;
            }

            for(int i=0;i<4;i++){
                int ax=bx+D[i][0];
                int ay=by+D[i][1];

                if(ax>=0 && ay>=0 && ax<N && ay<M){
                    if(arr[ax][ay]==0 && visited[ax][ay][wall]==false){ // 벽이 없는 경우 이동
                        result[ax][ay]=result[bx][by]+1;
                        visited[ax][ay][wall]=true;
                        q.add(new int[]{ax,ay,wall});
                    }
                    if(arr[ax][ay]==1 && wall==0 && visited[ax][ay][1]==false){ // 벽을 부수지 않은 경우
                        result[ax][ay]=result[bx][by]+1;                        // 1회 한에서 부수기
                        visited[ax][ay][1]=true;
                        q.add(new int[]{ax,ay,1});
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
