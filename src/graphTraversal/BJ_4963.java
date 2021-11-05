package graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
DFS,BFS문제를 풀다보면 반복문을 함수내부에서 써야할지 메인에서 써야할지
헷갈릴 때가 많다. 쉽게 생각하면 한번만 함수를 돈다면 반복문이 필요없는 것이고,
지금처럼 여러번 함수를 호출해야 하는 상황이라면 반복문이 필요할 것이다.
지금의 경우에는 한번만 호출해서는 모든 경우를 판단할 수 없기에 반복문을 조건식과 결합하였다.
그때그때 상황에 맞춰 어떨지 판단해보는 습관을 길러야겠다.
 */

public class BJ_4963 {

    static int D[][]={{-1,-1},{0,-1},{1,-1},{-1,0},{1,0},{-1,1},{0,1},{1,1}};
    static int w,h;
    static int arr[][];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list=new ArrayList<>();

        while (true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            w=Integer.parseInt(st.nextToken()); // 너비
            h=Integer.parseInt(st.nextToken()); // 높이
            arr=new int[h][w];
            visited=new boolean[h][w];
            int count=0;

            if(w==0 && h==0){
                for(int i=0;i<list.size();i++){
                    System.out.println(list.get(i));
                }
                break;
            }

            for(int i=0;i<h;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(arr[i][j]==1 && visited[i][j]==false){
                        DFS(i,j);
                        count++;
                    }
                }
            }
            list.add(count);
        }
    }

    public static void DFS(int x, int y){

        visited[x][y]=true;

        for(int i=0;i<8;i++){
            int ax=x+D[i][0];
            int ay=y+D[i][1];

            if(ax>=0 && ay>=0 && ax<h && ay<w){
                if(arr[ax][ay]==1 && visited[ax][ay]==false){
                    DFS(ax,ay);
                }
            }
        }
    }
}
