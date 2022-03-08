package baekjoon.Implementation;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int end, weight;

    public Node(int end, int weight){
        this.end=end;
        this.weight=weight;
    }

    public int compareTo(Node o){
        return weight-o.weight; // 오름차순
    }


}

public class BJ_1753 {

    static final int INF=987654321;
    static int V,E,K;
    static ArrayList<Node> list[];
    static int Dist[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        V=Integer.parseInt(st.nextToken()); // 정점
        E=Integer.parseInt(st.nextToken()); // 개수
        K=Integer.parseInt(br.readLine()); // 시작 정점
        list=new ArrayList[V+1];
        Dist=new int[V+1];

        for(int i=1;i<V+1;i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            list[u].add(new Node(v,w));
        }

        dijkstra(K);

        for(int i=1;i<V+1;i++){
            if(Dist[i]==INF){
                System.out.println("INF");
                continue;
            }
            System.out.println(Dist[i]);
        }

    }

    public static void dijkstra(int start){

        PriorityQueue<Node> pq=new PriorityQueue<>();
        boolean visited[]=new boolean[V+1];

        for(int i=1;i<V+1;i++){
            Dist[i]=INF;
        }
        Dist[start]=0;
        pq.add(new Node(start,0));

        while (!pq.isEmpty()){

            Node curr = pq.poll();
            int now=curr.end;
            if(visited[now]) continue;
            visited[now]=true;

            for(Node node:list[now]){
                if(Dist[node.end]>Dist[now]+node.weight){
                    Dist[node.end]=Dist[now]+node.weight;
                    pq.add(new Node(node.end, Dist[node.end]));
                }
            }
        }
    }
}
