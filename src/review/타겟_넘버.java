package review;

public class 타겟_넘버 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int numbers[]={1,1,1,1,1};
        int target=3;
        System.out.println(solution.solution(numbers,target));

    }

    static class Solution {
        public int solution(int[] numbers, int target) {
            int answer = dfs(numbers, target, 0, 0);
            return answer;
        }

        public int dfs(int numbers[], int target, int sum, int index) {
            if (numbers.length == index) {
                return (sum == target) ? 1 : 0;
            } else {
                return dfs(numbers, target, sum + numbers[index], index + 1)
                        + dfs(numbers, target, sum - numbers[index], index + 1);
            }
        }
    }
}
