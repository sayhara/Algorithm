package programmers.level3;

import java.util.Arrays;
import java.util.Comparator;

/*
크루스칼 알고리즘(MST)
 */

public class 섬_연결하기 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int n=4;
        int costs[][]={{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution.solution(n,costs));
    }

    static class Solution {

        int[] findParent;

        public int find(int child){ // 부모노드 찾기
            if(findParent[child]==child){
                return child;
            } else {
                return findParent[child]=find(findParent[child]);
            }
        }

        public int solution(int n, int[][] costs) {
            int answer = 0;

            Arrays.sort(costs, new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2]-o2[2]; //  비용 최소값 정렬
                }
            });

            findParent=new int[n];

            for(int i=0;i<n;i++){
                findParent[i]=i;
            }

            for(int i=0;i<costs.length;i++){
                int first = find(costs[i][0]);
                int second = find(costs[i][1]);
                if(first!=second){
                    findParent[second]=first;
                    answer+=costs[i][2];
                }
            }
            
            return answer;
        }
    }
}
