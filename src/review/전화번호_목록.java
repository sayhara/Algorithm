package review;

import java.util.HashMap;

public class 전화번호_목록 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        String phone_book[]={"123","456","789"};
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
                for(int j=0;j<phone_book[i].length();j++){
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
