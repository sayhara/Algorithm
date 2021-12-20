package programmers;

import java.util.*;

/*
기존의 이중 for문을 통한 equals의 문자열 비교시에는 시간초과가
발생하였다. 핵심은 containsKey라는 함수를 사용하는 것이었는데
이는 해당 키값이 존재하는지의 유무를 판별하는 것이다.
따라서, 이중 for문을 통해 문자열의 subString을 하여 값을 계산할 수 있다.
 */

public class 전화번호_목록 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        String phone_book[]={"12","123","1235","567","88"};
        System.out.println(solution.solution(phone_book));
    }

    static class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;

            HashMap<String, Integer> map=new HashMap<>();
            for(int i=0;i<phone_book.length;i++){
                map.put(phone_book[i],i);
            }

            for(int i=0;i<phone_book.length;i++){
                for(int j=1;j<phone_book[i].length();j++){
                    String sub=phone_book[i].substring(0,j);
                    if(map.containsKey(sub)){
                        answer=false;
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
