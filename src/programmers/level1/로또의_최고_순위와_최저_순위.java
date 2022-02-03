package programmers.level1;

import java.util.Arrays;

public class 로또의_최고_순위와_최저_순위 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int lottos[]={44,1,0,0,31,25};
        int win_nums[]={31,10,45,1,6,19};
        System.out.println(Arrays.toString(solution.solution(lottos,win_nums)));

    }

    static class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];

            for(int i=0;i<lottos.length;i++){
                for(int j=0;j<win_nums.length;j++){
                    if(lottos[i]==win_nums[j]){
                        answer[0]++;
                        answer[1]++;
                    }
                }
            }

            for(int i=0;i<lottos.length;i++){
                if(lottos[i]==0){
                    answer[0]++;
                }
            }

            for(int i=0;i<2;i++){
                if(answer[i]==6){
                    answer[i]=1;
                } else if(answer[i]==5){
                    answer[i]=2;
                } else if(answer[i]==4){
                    answer[i]=3;
                } else if(answer[i]==3){
                    answer[i]=4;
                } else if(answer[i]==2){
                    answer[i]=5;
                } else{
                    answer[i]=6;
                }
            }

            return answer;
        }
    }
}
