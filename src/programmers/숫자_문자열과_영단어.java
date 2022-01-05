package programmers;

public class 숫자_문자열과_영단어 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String s = "one4seveneight";
        System.out.println(solution2.solution(s));

    }

    // 유연하지 못한 방법
    static class Solution {
        public int solution(String s) {

            int answer = 0;

            if (s.contains("zero")) {
                s = s.replace("zero", "0");
            }
            if (s.contains("one")) {
                s = s.replace("one", "1");
            }
            if (s.contains("two")) {
                s = s.replace("two", "2");
            }
            if (s.contains("three")) {
                s = s.replace("three", "3");
            }
            if (s.contains("four")) {
                s = s.replace("four", "4");
            }
            if (s.contains("five")) {
                s = s.replace("five", "5");
            }
            if (s.contains("six")) {
                s = s.replace("six", "6");
            }
            if (s.contains("seven")) {
                s=s.replace("seven", "7");
            }
            if (s.contains("eight")) {
                s = s.replace("eight", "8");
            }
            if (s.contains("nine")) {
                s = s.replace("nine", "9");
            }

            answer = Integer.parseInt(s);
            return answer;
        }
    }

    // 유연한 방법
    static class Solution2{
        public int solution(String s) {

            int answer=0;
            String[] alpha={"zero","one","two","three","four","five","six","seven","eight","nine"};

            for(int i=0;i<alpha.length;i++){
                s=s.replace(alpha[i],Integer.toString(i));
            }

            answer=Integer.parseInt(s);
            return answer;
        }
    }
}
