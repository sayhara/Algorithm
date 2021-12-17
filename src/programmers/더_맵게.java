package programmers;

import java.util.PriorityQueue;

public class 더_맵게 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int s[]={1,2,3,9,19,12};
        int K=7;
        System.out.println(solution.solution(s,K));

    }

    static class Solution {
        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> heap=new PriorityQueue<>();
            int answer = 0;

            for(int num:scoville){
                heap.add(num);
            }

            while (heap.peek()<K){

                if(heap.size()==1){
                    return -1;
                }
                int a=heap.poll();
                int b=heap.poll();

                int mix=a+b*2;
                heap.add(mix);
                answer++;
            }

            return answer;
        }
    }
}
