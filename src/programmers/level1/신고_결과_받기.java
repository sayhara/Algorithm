package programmers.level1;

import java.util.*;

/*
HashMap, HashSet을 이용한 풀이
처음에 선언을 제대로 해야 문제 풀이가 가능할 것 같다.
 */

public class 신고_결과_받기 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        String[] id_list={"muzi", "frodo", "apeach", "neo"};
        String[] report={"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k=2;
        System.out.println(solution.solution(id_list,report,k));
    }

    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];
            HashMap<String ,Integer> map=new HashMap<>();
            HashSet<Integer>[] s=new HashSet[id_list.length];
            for(int i=0;i<id_list.length;i++){
                s[i]=new HashSet<>();
            }

            for(int i=0;i<id_list.length;i++){
                map.put(id_list[i],i);
            }

            for(String repo:report){
                String[] st = repo.split(" ");
                int id1 = map.get(st[0]); // muzi, apeach, frodo, muzi, apeach
                int id2 = map.get(st[1]); // frodo, frodo, neo,   neo,  muzi
                s[id2].add(id1); // 신고한 개수 count
            }

            for(int i=0;i<id_list.length;i++){
                if(s[i].size()<k) continue;
                for(int x:s[i]) answer[x]++;
            }
            return answer;
        }
    }
}
