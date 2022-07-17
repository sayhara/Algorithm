package programmers.level1;

public class 없는_숫자_더하기 {

    public static void main(String[] args) {

        Solution solution=new Solution();
        int[] numbers={1,2,3,4,6,7,8,0};
        System.out.println(solution.solution(numbers));

    }

    static class Solution {
        public int solution(int[] numbers) {
            int answer = 0;
            boolean flag[]=new boolean[10];

            for(int i=0;i<numbers.length;i++){
                flag[numbers[i]]=true;
            }

            for(int i=0;i<10;i++){
                if(!flag[i]){
                    answer+=i;
                }
            }
            return answer;
        }
    }
}
