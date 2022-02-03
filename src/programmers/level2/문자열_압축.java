package programmers.level2;

/*
https://jellyinghead.tistory.com/34
 */

public class 문자열_압축 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcabcdede";
        System.out.println(solution.solution(s));
    }

    static class Solution {
        public int solution(String s) {
            int answer = Integer.MAX_VALUE;
            if(s.length()==1) return 1; // 길이가 1이면 비교할 문자열이 없으므로 MAX_VALUE

            for (int i = 1; i <= s.length() / 2; i++) { // 자르는 길이
                StringBuilder sb = new StringBuilder();
                String temp = "";
                int cnt = 1;

                for (int j = 0; j < Math.ceil((double) s.length() / i); j++) {
                    String now = s.substring(i * j, i * (j + 1) >= s.length() ? s.length() : i * (j + 1));

                    if (!temp.equals(now)) {
                        if (cnt != 1) {
                            sb.append(cnt);
                            cnt = 1;
                        }
                        sb.append(temp);
                        temp = now;
                    } else {
                        cnt++;
                    }
                }

                if (cnt != 1) {
                    sb.append(cnt);
                }

                sb.append(temp);

                answer = Math.min(answer, sb.toString().length());
            }

            return answer;
        }
    }
}