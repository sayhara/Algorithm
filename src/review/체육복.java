package review;

import java.util.Arrays;

public class 체육복 {

    public static void main(String[] args) {

        Solution solution=new Solution();
        int n=3;
        int lost[]={3};
        int reserve[]={1};
        System.out.println(solution.solution(n,lost,reserve));
    }

    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {

            int answer=n-lost.length;
            Arrays.sort(lost);
            Arrays.sort(reserve);

            for(int i=0;i<lost.length;i++){
                for(int j=0;j<reserve.length;j++){
                    if(lost[i]==reserve[j]){
                        answer++;
                        lost[i]=-1;
                        reserve[j]=-1;
                        break;
                    }
                }
            }

            for(int i=0;i<lost.length;i++){
                for(int j=0;j<reserve.length;j++){
                    if(lost[i]-1==reserve[j] || lost[i]+1==reserve[j]){
                        answer++;
                        lost[i]=-1;
                        reserve[j]=-1;
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
