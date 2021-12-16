package programmers;

import java.util.*;

public class 기능개발 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int a[]={93,30,55};
        int b[]={1,30,5};
        System.out.println(Arrays.toString(solution.solution(a,b)));

    }

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> q=new LinkedList<>();
            for(int i=0;i<progresses.length;i++){
                q.add((int)Math.ceil((100-progresses[i])/speeds[i]));
            }
            ArrayList<Integer> list=new ArrayList<>();

            int prev=q.poll();
            int count=1;

            while (!q.isEmpty()){
                int cur=q.poll();
                if(prev>=cur){
                    count++;
                } else{
                    list.add(count);
                    count=1;
                    prev=cur;
                }
            }
            list.add(count);
            int answer[]=new int[list.size()];
            for(int i=0;i< list.size();i++){
                answer[i]=list.get(i);
            }
            return answer;
        }
    }
}
