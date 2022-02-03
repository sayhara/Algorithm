package programmers.level2;

public class _124_나라의_숫자 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int n=10;
        System.out.println(solution.solution(n));

    }
    // sol1
    static class Solution {
        public String solution(int n) {
            StringBuilder sb=new StringBuilder();

            while (n>0){
                int remain=n%3; // 나머지

                if(remain==0){
                    n--;
                    sb.append(4);
                } else if(remain==1){
                    sb.append(1);
                } else {
                    sb.append(2);
                }
                n/=3;
            }

            return sb.reverse().toString();
        }
    }

    static class Solution2 {
        public String solution(int n) {
            String[] num={"4","1","2"}; // 나머지가 0일때 4, 1일때 1, 2일때 2
            String answer="";

            while (n>0){
                answer=num[n%3]+answer;
                if(n%3==0){ // 보통 3진수는 0부터 시작하지만, 여기서는 1부터 시작
                            // https://taehoung0102.tistory.com/63
                    n--;
                }
                n=n/3;
            }
            return answer;
        }
    }
}
