package programmers.level2;

import java.util.*;

public class 캐시 {

    public static void main(String[] args) {

        Solution solution=new Solution();
        int cacheSize=3;
        String[] cities={"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(solution.solution(cacheSize,cities));

    }


    static class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;

            LinkedList<String> cache=new LinkedList<>();

            for(int i=0;i<cities.length;i++){

                if(cacheSize==0){
                    return 5*cities.length;
                }

                String city=cities[i].toUpperCase(); // 대소문자 구분하지 않음

                // Hit
                if(cache.remove(city)){
                    cache.addFirst(city);
                    answer+=1;
                }
                // Miss
                else {

                    if(cache.size()==cacheSize){
                        cache.pollLast();
                    }

                    cache.addFirst(city);
                    answer+=5;
                }

            }

            return answer;
        }
    }
}
