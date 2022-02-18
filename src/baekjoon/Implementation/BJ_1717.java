package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1717 {

    static int n,m;
    static int parent[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        parent=new int[n+1];

        for(int i=0;i<=n;i++){
            parent[i]=i;
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int num=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            if(num==0){
                union(x,y);
            } else {
                if(find(x)==find(y)){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static void union(int x, int y){

        x=find(x);
        y=find(y);
        if(x!=y) parent[y]=x; // 일반적으로 부모를 합칠때는 작을 쪽으로 합침
    }

    public static int find(int child){

        if(parent[child]==child){
            return child;
        }
        return parent[child]=find(parent[child]);
    }

}
