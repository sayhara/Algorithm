package programmers;

import java.util.Arrays;

public class 주식가격 {

    public static void main(String[] args) {

        Solution solution=new Solution();
        int prices[]={5,8,6,2,4,1};
        System.out.println(Arrays.toString(solution.solution(prices)));

    }

    static class Solution {
        public int[] solution(int[] prices) {

            int[] answer = new int[prices.length];

            for(int i=0;i<prices.length-1;i++){
                answer[i]++;
                for(int j=i+1;j<prices.length-1;j++){
                    if(prices[i]<=prices[j]){
                        answer[i]++;
                    } else{
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
