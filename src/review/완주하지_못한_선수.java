package review;

import java.util.HashMap;

/*
HashMap의 get()함수는 리턴값이 정수이다.
이를 활용한 함수가 getOrDefault()로 초기의 값을 설정할 수 있고, 중복되는 값에 대해서는
추가적인 기능을 부여할 수 있다.
 */

public class 완주하지_못한_선수 {

    public static void main(String[] args) {

        Solution solution=new Solution();
        String participant[]={"marina", "josipa", "nikola", "vinko", "filipa"};
        String completion[]={"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution.solution(participant,completion));
    }

    static class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String, Integer> map = new HashMap<>();

            for (String part : participant) {
                map.put(part, map.getOrDefault(part, 0) + 1); // 문자를 숫자로 치환
            }
            for (String comp : completion) {
                map.put(comp, map.get(comp) - 1); // map.get()의 리턴값은 정수이므로 중복요소 제거
            }
            for (String key : map.keySet()) {
                if (map.get(key) == 1) {
                    answer = key;
                }
            }
            return answer;
        }
    }
}
