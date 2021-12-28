package review;

import java.util.*;

public class 기능개발 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int progresses[]={95, 90, 99, 99, 80, 99};
        int speeds[]={1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution.solution(progresses,speeds)));

    }

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {

            Queue<Integer> q=new LinkedList<>();
            ArrayList<Integer> list=new ArrayList<>();

            for(int i=0;i< progresses.length;i++){
                double remain=(double)(100-progresses[i])/speeds[i];
                q.add((int) Math.ceil(remain));
            }

            int pre=q.poll();
            int count=1;

            while (!q.isEmpty()){
                int cnt=q.poll();
                if(pre>=cnt){
                    count++;
                } else{
                    list.add(count);
                    count=1;
                    pre=cnt;
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
