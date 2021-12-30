package review;

import java.util.*;

public class 프린터 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;
        System.out.println(solution.solution(priorities, location));
    }


    static class Solution {
        public int solution(int[] priorities, int location) {

            Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
            int answer = 0;

            for (int i = 0; i < priorities.length; i++) {
                queue.add(priorities[i]);
            }

            while (!queue.isEmpty()) {
                for (int i = 0; i < priorities.length; i++) {
                    if (queue.peek() == priorities[i]) {
                        queue.poll();
                        answer++; // 가장 먼저 나온것은 우선순위
                        if (location == i) {
                            return answer;
                        }
                    }
                }
            }

            return answer;
        }
    }
}

