package programmers.level2;

import java.util.*;

public class 전력망을_둘로_나누기 {

    static class Solution1 { // BFS

        static ArrayList<Integer> list[];

        public int solution(int n, int[][] wires) {
            int answer = 100;
            list=new ArrayList[n+1];

            for(int i=1;i<=n;i++){
                list[i]=new ArrayList<>();
            }

            for(int i=0;i<wires.length;i++){ // 트리의 연결
                int x=wires[i][0];
                int y=wires[i][1];
                list[x].add(y);
                list[y].add(x);
            }

            for(int i=0;i<wires.length;i++){

                int n1=bfs(wires[i][0],wires[i][1],n);
                int n2=bfs(wires[i][1],wires[i][0],n);

                answer=Math.min(answer,Math.abs(n1-n2));
            }

            return answer;
        }

        public static int bfs(int v1, int v2, int n){

            Queue<Integer> q=new LinkedList<>();
            boolean visited[]=new boolean[n+1];
            int count=0;

            q.add(v1);
            visited[v1]=true;

            while(!q.isEmpty()){

                int cur=q.poll();
                count++;

                for(int next:list[cur]){
                    if(next!=v2 && visited[next]==false){ // 하나씩 트리의 연결을 끊기
                        visited[next]=true;
                        q.add(next);
                    }
                }
            }
            return count;
        }
    }
}
