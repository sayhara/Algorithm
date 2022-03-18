package programmers.level2;

import java.util.*;

public class 후보키 {

    static class Solution {

        static List<String> candidate=new ArrayList<>();

        public int solution(String[][] relation) {
            int answer = 0;

            for(int i=1;i<=relation[0].length;i++){
                boolean visited[]=new boolean[relation[0].length];
                combination(relation,visited,relation[0].length,0,i);
            }
            answer=candidate.size();

            return answer;
        }

        public static void combination(String[][] relation, boolean[] visited, int n, int depth, int r){

            if(r==0){
                List<Integer> list=new ArrayList<>();
                String key="";
                for(int i=0;i<n;i++){
                    if(visited[i]){
                        key+=String.valueOf(i);
                        list.add(i);
                    }
                }
                // 유일성
                HashMap<String, Integer> map=new HashMap<>();

                for(int i=0;i<relation.length;i++){
                    String s="";
                    for(Integer j:list){
                        s+=relation[i][j];
                    }
                    if(map.containsKey(s)){ // 중복되면 유일성 x
                        return;
                    } else {
                        map.put(s,0);
                    }
                }
                // 최소성
                for(String s:candidate){
                    int count=0;
                    for(int i=0;i<key.length();i++){
                        String sub=String.valueOf(key.charAt(i));
                        if(s.contains(sub)) count++;
                    }
                    if(count==s.length()) return;

                }
                candidate.add(key);
                return;

            }

            for(int i=depth;i<n;i++){
                if(visited[i]==false){
                    visited[i]=true;
                    combination(relation,visited,n,i+1,r-1);
                    visited[i]=false;
                }
            }
        }
    }
}
