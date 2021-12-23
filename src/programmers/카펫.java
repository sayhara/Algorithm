package programmers;

import java.util.ArrayList;
import java.util.Arrays;

/*
Brown + Yellow = 가로 x 세로
(가로 -2) X (세로-2) = Yellow
 */

public class 카펫 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int brown=24,yellow=24;
        System.out.println(Arrays.toString(solution.solution(brown,yellow)));

    }

    static class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            int sum=brown+yellow;
            ArrayList<Integer> list=new ArrayList<>();

            for(int i=1;i<=sum;i++){
                if(sum%i==0){
                    list.add(i); // 약수의 조합 (1,2,3,4,6,12), (1,2,4,8,16)
                }
            }

            for(int i=0;i<list.size();i++){ // 가로
                for(int j=0;j<list.size();j++){ // 세로
                    if(list.get(i)*list.get(j)==sum){
                        if((list.get(i)-2)*(list.get(j)-2)==yellow){
                            answer[0]=list.get(i);
                            answer[1]=list.get(j);
                            break;
                        }
                    }
                }
            }
            return answer;
        }
    }
}
