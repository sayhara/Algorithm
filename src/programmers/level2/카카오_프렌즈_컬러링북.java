package programmers.level2;

import java.util.Arrays;

public class 카카오_프렌즈_컬러링북 {

    public static void main(String[] args) {

        Solution solution=new Solution();
        int m=6;
        int n=4;
        int[][] picture={{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
        System.out.println(Arrays.toString(solution.solution(m,n,picture)));

    }

    static class Solution {

        static int M,N;
        static int arr[][];
        static boolean visited[][];
        static int value=0;
        static int count=1;
        static int D[][]={{-1,0},{1,0},{0,1},{0,-1}}; // 상하좌우
        
        public int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;

            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;

            M=m; N=n;
            arr=picture;
            visited=new boolean[m][n];

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(arr[i][j]!=0 && visited[i][j]==false){
                        value=arr[i][j];
                        dfs(i,j);
                        answer[1]=Math.max(answer[1],count);
                        count=1;
                        answer[0]++;
                    }
                }
            }

            return answer;
        }

        public static void dfs(int x, int y){

            visited[x][y]=true;

            for(int i=0;i<4;i++){
                int ax=x+D[i][0];
                int ay=y+D[i][1];

                if(ax>=0 && ay>=0 && ax<M && ay<N){
                    if(arr[ax][ay]==value && visited[ax][ay]==false){
                        dfs(ax,ay);
                        count++;
                    }
                }
            }
        }
    }
}
