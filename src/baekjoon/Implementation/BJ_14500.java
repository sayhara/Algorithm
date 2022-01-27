package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14500 {

    static int N,M;
    static int arr[][];
    static boolean visited[][];
    static int dx[]={-1,1,0,0}; // ㅜ 제외 ~> DFS 탐색가능
    static int dy[]={0,0,1,-1};
    static int ex[][]={{0,0,0,1},{0,0,-1,1},{0,0,-1,0},{0,1,2,1}}; // ㅜ, ㅓ, ㅗ, ㅏ
    static int ey[][]={{0,1,2,1},{0,1,1,1},{0,1,1,2},{0,0,0,1}};

    static int max=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        visited=new boolean[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                visited[i][j]=true;
                dfs(i,j,arr[i][j],1);
                visited[i][j]=false;
//                check_cycle(i,j);
                check(i,j);
            }
        }
        System.out.println(max);
    }

    public static void dfs(int x, int y, int sum, int length){

        if(length==4){
            max=Math.max(max,sum);
            return;
        }

        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, sum + arr[nx][ny], length + 1);
                    visited[nx][ny] = false;
                }
            }
        }
    }

    public static void check_cycle(int x, int y){

        for(int i=0;i<4;i++){
            int sum=0;
            for(int j=0;j<4;j++){
                int nx=x+ex[i][j];
                int ny=y+ey[i][j];

                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    sum+=arr[nx][ny];
                    max=Math.max(max,sum);
                }
            }
        }
    }

    // ㅜ 모양 검사
    
    public static void check(int x, int y){

        int sum=0;
        // ㅜ
        if(x>=0 && x+1<N && y>=0 && y+2<M){
            sum=arr[x][y]+arr[x][y+1]+arr[x][y+2]+arr[x+1][y+1];
            max=Math.max(max,sum);
        }

        // ㅓ
        if(x-1>=0 && x+1<N && y>=0 && y+1<M){
            sum=arr[x][y]+arr[x][y+1]+arr[x-1][y+1]+arr[x+1][y+1];
            max=Math.max(max,sum);
        }

        // ㅗ
        if(x-1>=0 && x<N && y>=0 && y+2<M){
            sum=arr[x][y]+arr[x][y+1]+arr[x-1][y+1]+arr[x][y+2];
            max=Math.max(max,sum);
        }

        // ㅏ
        if(x>=0 && x+2<N && y>=0 && y+1<M){
            sum=arr[x][y]+arr[x+1][y]+arr[x+2][y]+arr[x+1][y+1];
            max=Math.max(max,sum);
        }
    }
}
