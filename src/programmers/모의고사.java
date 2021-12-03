package programmers;

import java.util.ArrayList;
import java.util.Arrays;

/*
ArrayList의 size만큼 배열에 대입해주는 솔루션
 */
public class 모의고사 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int answer[]={1,2,3,4,5,6,7,8,9,10};
        int sol[]=solution.solution(answer);
        System.out.println(Arrays.toString(sol));

    }

    static class Solution {
        public int[] solution(int[] answers) {

            int first[] = {1, 2, 3, 4, 5};
            int second[] = {2, 1, 2, 3, 2, 4, 2, 5};
            int third[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
            int one = 0, two = 0, three = 0;

            for (int i = 0; i < answers.length; i++) {
                if(answers[i]==first[i%5]){
                    one++;
                }
                if (answers[i] == second[i%8]) {
                    two++;
                }
                if(answers[i]==third[i%10]){
                    three++;
                }
            }

            ArrayList<Integer> list=new ArrayList<>();

            int max=Math.max(Math.max(one,two),three); // 최댓값 추출

            if(max==one) list.add(1);
            if(max==two) list.add(2);
            if(max==three) list.add(3);
            int answer[]=new int[list.size()];

            for(int i=0;i<answer.length;i++){
                answer[i]=list.get(i);
            }

            return answer;
        }
    }
}
