package programmers.level3;

import java.util.*;

public class 베스트앨범 {

    static class Solution {
        public int[] solution(String[] genres, int[] plays) {

            HashMap<String, Integer> map=new HashMap<>();
            ArrayList<Integer> result=new ArrayList<>();

            for(int i=0;i<genres.length;i++){
                map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]); // 같은 장르에 대한 덧셈연산
            }
            // classic 1450, pop 3100
            ArrayList<String> list=new ArrayList<>(map.keySet());
            Collections.sort(list, new Comparator<String>(){

                public int compare(String s1, String s2){
                    return map.get(s2)-map.get(s1);
                }

            });
            // pop, classic (value가 큰 순서대로)
            for(String s:list){

                int first=0;
                int second=0;
                int max=0;

                for(int i=0;i<genres.length;i++){
                    if(s.equals(genres[i])){
                        if(max<plays[i]){
                            max=plays[i];
                            first=i; // max의 index
                        }
                    }
                }

                result.add(first);
                max=0;

                for(int i=0;i<genres.length;i++){
                    if(s.equals(genres[i])){
                        if(i!=first && max<plays[i]){
                            max=plays[i];
                            second=i;
                        }
                    }
                }
                if(max!=0) result.add(second); // 장르내 노래가 하나일 수도 있음
            }

            int[] answer=new int[result.size()];

            for(int i=0;i<answer.length;i++){
                answer[i]=result.get(i);
            }

            return answer;
        }
    }

}
