package programmers.level2;

import java.util.*;

/*
옷의 종류가 x,y,z일 때
옷을 입지 않는 경우 +1을 더하여
(x+1)(y+1)(z+1)의 경우가 생긴다.
이때, 모든 옷을 입지 않는 경우는 제외해야 하므로 -1의 과정이 필요
 */

public class 위장 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        String clothes[][]= {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}
                , {"green_turban", "headgear"}};
        String clothes2[][]= {{"crowmask", "face"}, {"bluesunglasses", "face"}
                        , {"smoky_makeup", "face"}};
        System.out.println(solution.solution(clothes));
    }

    static class Solution {
        public int solution(String[][] clothes) {
            HashMap<String, Integer> map=new HashMap<>();
            int answer=clothes.length;

            for(int i=0;i< clothes.length;i++){
                map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
            }

//            for(Map.Entry<String, Integer> entry:map.entrySet()){
//                System.out.println("key:"+entry.getKey()+" value:"+entry.getValue());
//            }

            if(map.size()>1){
                answer=1;
                for(String key:map.keySet()){
                    answer*=map.get(key)+1;
                }
                answer--;
            }

            return answer;
        }
    }
}
