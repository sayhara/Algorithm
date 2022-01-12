package programmers;

public class 다트_게임 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String dartResult = "1D2S#10S";
        System.out.println(solution.solution(dartResult));
    }

    static class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            int result[] = new int[3];
            String temp = "";
            int num = 0, idx = 0;

            for (int i = 0; i < dartResult.length(); i++) {
                char ch = dartResult.charAt(i);

                if (ch >= '0' && ch <= '9') {
                    temp += ch - '0';
                } else if (ch == 'S' || ch == 'D' || ch == 'T') {
                    num = Integer.parseInt(temp); // 계산하기 위해서 변환
                    if (ch == 'S')
                        result[idx++] = (int) Math.pow(num, 1);
                    else if (ch == 'D')
                        result[idx++] = (int) Math.pow(num, 2);
                    else if (ch == 'T')
                        result[idx++] = (int) Math.pow(num, 3);
                    temp = "";
                } else {
                    if (ch == '#') {
                        result[idx - 1] *= -1;
                    } else {
                        result[idx - 1] *= 2;
                        if (idx > 1) result[idx - 2] *= 2;
                    }
                }
            }
            for (int i = 0; i < result.length; i++) {
                answer += result[i];
            }
            return answer;
        }
    }
}