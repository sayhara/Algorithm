package programmers;

public class 타겟_넘버 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int numbers[] = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution.solution(numbers, target));

    }

    static class Solution {

        public int solution(int[] numbers, int target) {

            int answer = dfs(numbers, target, 0, 0);
            return answer;
        }

        public int dfs(int[] numbers, int target, int index, int sum) {
            if (index == numbers.length) { // 모든 자리에 대한 탐색을 하는 경우
                return target == sum ? 1 : 0;
            } else {
                return dfs(numbers, target, index + 1, sum + numbers[index])
                        + dfs(numbers, target, index + 1, sum - numbers[index]);
            }
        }
    }
}
