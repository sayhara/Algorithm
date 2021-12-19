package programmers;

import java.util.Arrays;
import java.util.Comparator;
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
            Arrays.sort(phone_book, new Comparator<String>() { // 문자열 길이 오름차순
                @Override
                public int compare(String s1, String s2) {
                    return s1.length()-s2.length();
                }
            });

            HashMap<String, Integer> map=new HashMap<>();
            for(int i=0;i<phone_book.length;i++){
                map.put(phone_book[i],i);
            }

            for(int i=0;i<phone_book.length-1;i++){
                for(int j=i+1;j<phone_book.length;j++){
                    String sub=phone_book[j].substring(0, phone_book[i].length());
                    if(map.containsKey(sub)){
                        answer=false;
                        break;
                    }
                    if(phone_book[i].equals(sub)){
                        answer=false;
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
