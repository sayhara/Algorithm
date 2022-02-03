package programmers.level2;

import java.util.*;
/*
정렬
new Comparator -> compare() 메서드
리턴값이 음수 또는 0이면 객체의 자리 유지,
양수인 경우 두 객체의 자리 변경
 */

public class 가장_큰_수 {

    public static void main(String[] args) {

        Solution solution=new Solution();
        int numbers[]={6,10,2};
        System.out.println(solution.solution(numbers));

    }

    static class Solution {
        public String solution(int[] numbers) {

            String[] change=new String[numbers.length];
            String answer = "";

            for(int i=0;i<numbers.length;i++) {
                change[i]=Integer.toString(numbers[i]);
            }

            Arrays.sort(change, new Comparator<String>() {

                @Override
                public int compare(String s1, String s2) {
                    return (s2 + s1).compareTo(s1 + s2);
                }
            });

            if(change[0].equals("0")){
                return "0";
            }

            for(int i=0;i<change.length;i++){
                answer+=change[i];
            }

            return answer;
        }
    }
}
