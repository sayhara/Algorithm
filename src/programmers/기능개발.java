package programmers;

import java.util.*;

/*
정수형 / 정수형 = 정수형
ex) 4/3 -> 1
 */

public class 기능개발 {

    public static void main(String[] args) {

        Solution solution=new Solution();
        int[] progresses={96,94};
        int[] speeds={3,3};
        System.out.println(Arrays.toString(solution.solution(progresses,speeds)));

    }

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {

            Queue<Integer> q=new LinkedList<>();
            ArrayList<Integer> list=new ArrayList<>();

            for(int i=0;i<progresses.length;i++){
                q.add((int) Math.ceil((double) (100-progresses[i])/speeds[i])); // 마무리 가능한 기간
            }

            int pre=q.poll();
            int count=1;
            while (!q.isEmpty()){
                int cur=q.poll();
                if(pre>=cur){
                    count++;
                } else {
                    list.add(count);
                    count = 1;
                    pre=cur;
                }
            }
            list.add(count);

            int[] answer = new int[list.size()];

            for(int i=0;i<list.size();i++){
                answer[i]=list.get(i);
            }

            return answer;
        }
    }
}
