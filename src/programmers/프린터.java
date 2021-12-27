package programmers;

import java.util.*;

public class 프린터 {

    public static void main(String[] args) {

        Solution solution=new Solution();
        int[] priorities={2,1,3,2};
        int location=2;
        System.out.println(solution.solution(priorities,location));

    }

    static class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;

            PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 정렬
            for(int i=0;i<priorities.length;i++){
                pq.add(priorities[i]);
            }

            while (!pq.isEmpty()){
                for(int i=0;i<priorities.length;i++){
                    if(pq.peek()==priorities[i]){
                        pq.poll();
                        answer++;
                        if(i==location){ // 해당위치에 도달
                            return answer;
                        }
                    }
                }
            }

            return answer;
        }
    }
}
