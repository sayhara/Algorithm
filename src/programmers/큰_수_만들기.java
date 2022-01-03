package programmers;

/*
문자열 연결시 StringBuilder를 사용하면
연산시간을 크게 줄일 수 있음.
 */

public class 큰_수_만들기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String number = "1924";
        int k = 2;
        System.out.println(solution.solution(number, k));
    }

    static class Solution {
        
        public String solution(String number, int k) {
            StringBuilder answer=new StringBuilder();
            int index=0;

            for(int i=0;i<number.length()-k;i++){ // 구하려는 코드의 길이
                char max='0';
                for(int j=index;j<=k+i;j++){ // 하나씩 줄어든다고 했을 때
                    if(max<number.charAt(j)) {
                        max = number.charAt(j);
                        index=j+1; // 다음 인덱스
                    }
                }
                answer.append(max);
            }

            return answer.toString();
        }
    }
}
