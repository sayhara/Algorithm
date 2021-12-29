package review;

import java.util.*;

public class 가장_큰_수 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int numbers[]={0,0};
        System.out.println(solution.solution(numbers));
    }

    static class Solution {
        public String solution(int[] numbers) {

            String ch[]=new String[numbers.length];
            String answer = "";

            for(int i=0;i<numbers.length;i++){
                ch[i]=Integer.toString(numbers[i]);
            }

            Arrays.sort(ch, new Comparator<String>() {

                @Override
                public int compare(String s1, String s2) {
                    return (s2+s1).compareTo(s1+s2);
                    // (s2+s1)의 문자열이 (s1+s2) 보다 더 크다면 교환
                }
            });

            if(ch[0].equals("0")){
                return "0";
            }

            for(int i=0;i<ch.length;i++){
                answer+=ch[i];
            }

            return answer;
        }
    }
}
