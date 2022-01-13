package programmers;

import java.util.*;

public class 문자열_내_마음대로_정렬하기 {

    public static void main(String[] args) {

        Solution solution=new Solution();
        String[] strings={"sun", "bed", "car"};
        int n=1;
        System.out.println(solution.solution(strings,n));

    }

    static class Solution {
        public String[] solution(String[] strings, int n) {
            String[] answer = {};

            Arrays.sort(strings, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {

                    if(s1.charAt(n)>s2.charAt(n)){
                        return 1;
                    } else if(s1.charAt(n)==s2.charAt(n)){
                        return s1.compareTo(s2);
                    }
                    return -1;
                }
            });

            answer=strings;

            return answer;
        }
    }
}
