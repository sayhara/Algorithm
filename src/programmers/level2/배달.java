package programmers.level2;

import java.util.*;

public class 배달 {

    class Solution { // 방법 1 : 플로이드 와샬 개념
        public int solution(int N, int[][] road, int K) {
            int answer = 0;
            int map[][]=new int[N][N];

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==j){
                        map[i][j]=0;
                        continue;
                    }
                    map[i][j]=500001; // MAX
                }
            }

            for(int i=0;i<road.length;i++){
                int start=road[i][0]-1;
                int end=road[i][1]-1;
                if(map[start][end]<road[i][2])
                    continue;
                map[start][end]=road[i][2];
                map[end][start]=road[i][2];
            }

            for(int k=0;k<N;k++){
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        if(map[i][j]>map[i][k]+map[k][j]){
                            map[i][j]=map[i][k]+map[k][j];
                        }
                    }
                }
            }

            for(int i=0;i<N;i++){
                if(map[0][i]<=K)
                    answer++;
            }

            return answer;
        }
    }

    static class Solution2 { // 방법 2 : 다익스트라 알고리즘

        static ArrayList<Node> list[];
        static int dist[];
        static boolean visited[];

        public int solution(int N, int[][] road, int K) {
            int answer = 0;

            list=new ArrayList[N+1];
            dist=new int[N+1];
            visited=new boolean[N+1];

            for(int i=1;i<N+1;i++){
                list[i]=new ArrayList<>();
            }
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[1]=0;

            for(int i=0;i<road.length;i++){
                int start=road[i][0];
                int end=road[i][1];
                int weight=road[i][2];
                list[start].add(new Node(end,weight));
                list[end].add(new Node(start,weight));
            }

            dijkstra();

            for(int i=1;i<N+1;i++){
                if(dist[i]<=K){
                    answer++;
                }
            }

            return answer;
        }

        public static void dijkstra(){

            PriorityQueue<Node> pq=new PriorityQueue<>();
            pq.add(new Node(1,0)); // 처음에 1이 대입

            while(!pq.isEmpty()){

                Node curNode=pq.poll();
                int curr=curNode.end;
                if(visited[curr]) continue;
                visited[curr]=true;

                for(Node node:list[curr]){
                    if(dist[node.end]>dist[curr]+node.weight){
                        dist[node.end]=dist[curr]+node.weight;
                        pq.add(new Node(node.end,dist[node.end]));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node>{

        int end;
        int weight;

        public Node(int end, int weight){
            this.end=end;
            this.weight=weight;
        }

        public int compareTo(Node o){
            return this.weight-o.weight;
        }

    }
}
