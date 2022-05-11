package programmers.level2;

import java.util.*;

public class 압축 {

    static class Solution {

        static ArrayList<Integer> list=new ArrayList<>();
        static HashMap<String, Integer> map=new HashMap<>();

        public int[] solution(String msg) {

            String word[]={"A","B","C","D","E","F","G","H","I","J","K","L",
                    "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

            for(int i=0;i<word.length;i++){
                map.put(word[i],i+1);
            }

            LZW(msg);

            int[] answer = new int[list.size()];

            for(int i=0;i<list.size();i++){
                answer[i]=list.get(i);
            }

            return answer;
        }

        public static void LZW(String str){

            for(int i=0;i<str.length();i++){

                String s=str.substring(0,i+1);
                if(!map.containsKey(s)){
                    list.add(map.get(str.substring(0,i)));
                    map.put(s,map.size()+1);
                    LZW(str.substring(i));
                    break;
                }
                else {
                    if(i+1==str.length()){
                        list.add(map.get(s));
                    }
                }
            }
        }

    }
}
