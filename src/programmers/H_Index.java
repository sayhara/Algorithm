package programmers;

public class H_Index {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] citations = {3, 0, 6, 1, 5};
        int[] new_citations = {0, 1, 1};
        System.out.println(solution.solution(citations));
    }

    static class Solution {
        public int solution(int[] citations) {

            int answer = 0;
            for (int i = citations.length; i >= 0; i--) {
                int count = 0;
                for (int j = 0; j < citations.length; j++) {
                    if (citations[j] >= i) {
                        count++;
                    }
                }
                if (count >= i) {
                    answer = i;
                    break;
                }
            }
            return answer;
        }
    }
}
