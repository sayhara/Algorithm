package programmers;

public class 조이스틱 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        String name="JEROEN";
        System.out.println(solution.solution(name));
    }

    static class Solution {
        public int solution(String name) {
            int answer = 0;
            int UD=0;
            int LR=name.length() - 1; // 오른쪽으로만 이동

            for(int i=0;i<name.length();i++) {
                UD = Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1); // 위아래
                answer += UD;

                int next = i + 1;
                while (next < name.length() && name.charAt(next) == 'A')
                    next++;

                LR = Math.min(LR, (i * 2) + name.length() - next);
            }
                answer+=LR;

            return answer;
        }
    }
}
