package programmers.level2;

import java.util.*;

public class 오픈채팅방 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(solution.solution(record));
    }

    static class Solution {
        public ArrayList<String> solution(String[] record) {
            ArrayList<String> answer = new ArrayList<>();
            HashMap<String, String> map = new HashMap<>();

            for (int i = 0; i < record.length; i++) {
                String s[] = record[i].split(" ");
                if (s[0].startsWith("E") || s[0].startsWith("C")) {
                    map.put(s[1], s[2]); // uid1234 Prodo, uid4567 Ryan
                }
            }

            for (int i = 0; i < record.length; i++) { // uid1234 Muzi, uid4567 Prodo ...
                String s[] = record[i].split(" ");

                if (s[0].startsWith("E")) {
                    answer.add(map.get(s[1]).toString() + "님이 들어왔습니다."); // 같은 값이 없으면 add를 안함
                } else if (s[0].startsWith("L")) {
                    answer.add(map.get(s[1]).toString() + "님이 나갔습니다.");
                }
            }
            return answer;
        }
    }
}
