package programmers;

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
            if (s.length() == 1) return 1;

            for (int i = 1; i <= s.length() / 2; i++) {
                StringBuilder sb = new StringBuilder();
                String now = "";
                int cnt = 1;

                for (int j = 0; j < Math.ceil((double) s.length() / i); j++) {
                    String next = s.substring(i * j, i * (j + 1) >= s.length() ? s.length() : i * (j + 1));
                    if (!now.equals(next)) {
                        if (cnt != 1) {
                            sb.append(cnt);
                            cnt = 1;
                        }
                        sb.append(now);
                        now = next; // 현재값으로 치환
                    } else {
                        cnt++;
                    }
                }

                if (cnt != 1) { // 마지막 값
                    sb.append(cnt);
                }
                sb.append(now);

                answer = Math.min(answer, sb.toString().length());
            }

            return answer;
        }
    }
}
