package programmers.level2;

public class N개의_최소공배수 {

    static class Solution {
        public int solution(int[] arr) {
            int answer = arr[0];

            for(int i=1;i<arr.length;i++){

                int gcd=gcd(answer,arr[i]); // 최대공약수
                answer=answer*arr[i]/gcd; // 최소공배수
            }

            return answer;
        }

        public static int gcd(int a, int b){

            int x=Math.max(a,b);
            int y=Math.min(a,b);

            while(x%y!=0){ // 나머지가 0이 될때까지
                int r=x%y;
                x=y;
                y=r;
            }
            return y;

        }
    }
}
