package programmers;

import java.util.Stack;

public class 짝지어_제거하기 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        String s="baabaa";
        System.out.println(solution.solution(s));

    }

    static class Solution {
        public int solution(String s)
        {
            int answer = -1;
            Stack<Character> stack=new Stack<>(); // LIFO

            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);

                if(!stack.isEmpty() && stack.peek()==ch){
                    stack.pop();
                } else {
                    stack.add(ch);
                }

            }

            if(stack.size()==0){
                answer=1;
            } else {
                answer=0;
            }

            return answer;
        }
    }
}
