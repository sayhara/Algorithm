package review;

import java.util.HashMap;

public class 위장 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        String clothes[][]= {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}
                , {"green_turban", "headgear"}};
        String clothes2[][]= {{"crowmask", "face"}, {"bluesunglasses", "face"}
                , {"smoky_makeup", "face"}};
        System.out.println(solution.solution(clothes2));
    }

    static class Solution {
        public int solution(String[][] clothes) {

            HashMap<String, Integer> map=new HashMap<>();
            for(int i=0;i<clothes.length;i++){
                map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
            }

            int answer=1;

            if(map.size()>1){
                for(String s:map.keySet()){
                    answer*=map.get(s)+1;
                }
                answer--;
            } else {
                answer=clothes.length;
            }

            return answer;
        }
    }
}
