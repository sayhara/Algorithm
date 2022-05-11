package programmers.level2;

public class 다음_큰_숫자 {

    class Solution {
        public int solution(int n) {
            int answer = 0;
            String s=Integer.toBinaryString(n);
            int result=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1') result++;
            }

            for(int i=n+1;i<=1000000;i++){
                int cnt=0;
                String temp=Integer.toBinaryString(i);
                for(int j=0;j<temp.length();j++){
                    if(temp.charAt(j)=='1') cnt++;
                }
                if(cnt==result){
                    answer=i;
                    break;
                }
            }

            return answer;
        }
    }
}
