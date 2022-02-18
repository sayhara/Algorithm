package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1197 {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int V=Integer.parseInt(st.nextToken()); // 정점
        int E=Integer.parseInt(st.nextToken()); // 간선
        parent=new int[V+1];
        int costs[][]=new int[E][3]; // MST를 위해서는 최소비용을 오름차순으로 정렬
        int result=0;

        for(int i=1;i<=V;i++){
            parent[i]=i;
        }

        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            costs[i][0]=Integer.parseInt(st.nextToken());
            costs[i][1]=Integer.parseInt(st.nextToken());
            costs[i][2]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(costs, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2]; // 기본적으로 가중치는 오름차순으로 정렬되어야 함
            }
        });

        for(int i=0;i<E;i++){

            int x=find(costs[i][0]);
            int y=find(costs[i][1]);
            if(x!=y){
                result+=costs[i][2]; // 두 간선에 대한 연결을 함
                parent[y]=x;
            }
        }

        System.out.println(result);
    }

    public static int find(int child){

        if(child==parent[child])
            return child;
        return parent[child]=find(parent[child]);
    }
}
