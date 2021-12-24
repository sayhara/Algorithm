package programmers;

public class 네트워크 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int n=3;
        int computers[][]={{1,1,0},{1,1,1},{0,1,1}};
        System.out.println(solution.solution(n,computers));

    }

    static class Solution {

        static boolean visited[];

        public int solution(int n, int[][] computers) {

            visited=new boolean[n];
            int answer = 0;

            for(int i=0;i<n;i++){
                if(visited[i]==false){
                    dfs(n,computers,i);
                    answer++;
                }
            }

            return answer;
        }

        public static void dfs(int n, int[][] computers, int start){

            visited[start]=true;

            for(int i=0;i<n;i++) {
                if(computers[start][i]==1 && visited[i]==false){
                    dfs(n,computers,i);
                }
            }
        }
    }
}
