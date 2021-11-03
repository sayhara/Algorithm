package graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
탐색을 하며 총 단지수를 출력하는 것이므로 DFS,BFS로 모두 가능하다.
처음 이중 반복문을 통해 요소가 1인 경우 DFS()를 호출하도록 처리한 뒤,
이웃하는 범위에 있으면 ArrayList에 요소를 추가해 주었다.
이후 오름차순을 위해 정렬을 한 뒤 값을 출력하였다.
 */
public class BJ_2667 {

    static int N;
    static int arr[][];
    static boolean visited[][];
    static int D[][]={{-1,0},{1,0},{0,1},{0,-1}};
    static ArrayList<Integer> list=new ArrayList<>();
    static int count=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        visited=new boolean[N][N];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j]=s.charAt(j)-'0';
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]==1 && visited[i][j]==false){
                    count++;
                    DFS(i,j);
                    list.add(count);
                    count=0;
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public static void DFS(int x,int y){
        visited[x][y]=true;

        for(int i=0;i<4;i++){
            int ax=x+D[i][0];
            int ay=y+D[i][1];

            if(ax>=0 && ay>=0 && ax<N && ay<N){
                if(arr[ax][ay]==1 && visited[ax][ay]==false){
                    DFS(ax,ay);
                    count++;
                }
            }
        }
    }
}
