package programmers;

import java.util.*;

/*
시간복잡도를 줄이는 방안 생각
 */

public class 완주하지_못한_선수 {

    class Solution {
        public String solution(String[] participant, String[] completion) {

            String answer = "";
            HashMap<String, Integer> hash = new HashMap<>();

            for (String part : participant) {
                hash.put(part, hash.getOrDefault(part, 0) + 1);
                // getOrDefault(key,0) : 키 값이 존재하면 key 넣고 아니면 0을 대입
            }

            for (String comp : completion) {
                hash.put(comp, hash.get(comp) - 1);
            }

            for (String value : hash.keySet()) {
                if (hash.get(value) == 1) {
                    answer = value;
                }
            }

            return answer;
        }
    }
}
