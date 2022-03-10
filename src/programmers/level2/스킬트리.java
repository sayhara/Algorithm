package programmers.level2;

import java.util.*;

public class 스킬트리 {

    public static void main(String[] args) {

        String skill="CBD";
        String[] skill_trees={"BACDE", "CBADF", "AECB", "BDA"};
        Solution solution=new Solution();
        System.out.println(solution.solution(skill,skill_trees));
    }

    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            // C->B->D
            boolean alpha[]=new boolean[26];
            Queue<Character> list[]=new LinkedList[skill_trees.length];
            for(int i=0;i<skill.length();i++){
                alpha[skill.charAt(i)-65]=true;
            }

            for(int i=0;i<skill_trees.length;i++){
                list[i]=new LinkedList<>();
            }

            for(int i=0;i<skill_trees.length;i++){
                for(int j=0;j<skill_trees[i].length();j++){
                    if(alpha[skill_trees[i].charAt(j)-65]){
                        list[i].add(skill_trees[i].charAt(j));
                    }
                }
            }

            // BCD, CBD, CB, BD // CBD
            for(int i=0;i<skill_trees.length;i++){

                Queue<Character> q=new LinkedList<>();
                for(int j=0;j<skill.length();j++){
                    q.add(skill.charAt(j)); // C, B, D
                }

                while(!list[i].isEmpty()){

                    if(list[i].peek()==q.peek()){
                        list[i].poll();
                        q.poll();
                    }
                    else {
                        break;
                    }
                }

                if(list[i].size()==0){
                    answer++;
                }
            }

            return answer;
        }
    }

    static class Solution2 {
        public int solution(String skill, String[] skill_trees) {

            int answer= skill_trees.length;

            for(int i=0;i< skill_trees.length;i++){ // ^ : 문자열 시작
                if(skill.indexOf(skill_trees[i].replaceAll("[^"+skill+"]",""))!=0){
                    answer--;
                }
            }

            return answer;

        }
    }
}
