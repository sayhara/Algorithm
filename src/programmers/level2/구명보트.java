package programmers.level2;

import java.util.Arrays;

public class 구명보트 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] people={70,50,80,50};
        int limit=100;
        System.out.println(solution.solution(people,limit));
    }

    static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;

            Arrays.sort(people); // 오름차순
            int left=0;
            int right=people.length-1;

            while (left<=right){
                int last=people[right--];
                if(people[left]+last<=limit){
                    left++;
                }
                answer++;
            }

            return answer;
        }
    }
}
