package programmers.level1;

public class 음양_더하기 {

    public static void main(String[] args) {

    }

    class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;

            for(int i=0;i<absolutes.length;i++){
                if(!signs[i]){
                    absolutes[i]=-absolutes[i];
                }
                answer+=absolutes[i];
            }

            return answer;
        }
    }
}
