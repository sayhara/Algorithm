package programmers;

public class 멀쩡한_사각형 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int w = 12;
        int h = 8;
        System.out.println(solution.solution(w, h));
    }

    static class Solution {
        public long solution(int w, int h) {
            long answer = 0;
            long remain = 0;
            double len = h;

            for (int i = 1; i <= w; i++) {
                double len2 = -i * (double) h / w + h; // 기울기 생각
                remain += (int) Math.ceil(len) - (int) Math.floor(len2);
                len = len2;
            }

            answer = (long) w * h - remain;
            return answer;
        }
    }
}
