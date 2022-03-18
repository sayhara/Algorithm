package programmers.level2;

public class 피로도 {

    static class Solution {

        static int answer=0;
        static boolean[] visited;

        public int solution(int k, int[][] dungeons) {
            visited=new boolean[dungeons.length];

            dfs(dungeons, k, 0);

            return answer;
        }

        public static void dfs(int[][] dungeons, int k, int depth){

            for(int i=0;i<dungeons.length;i++){

                if(!visited[i] && k>=dungeons[i][0]){
                    visited[i]=true;
                    dfs(dungeons,k-dungeons[i][1],depth+1);
                    visited[i]=false;
                }
            }
            answer=Math.max(depth,answer);
        }
    }
}
