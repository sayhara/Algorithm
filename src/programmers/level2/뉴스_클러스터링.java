package programmers.level2;

import java.util.*;

public class 뉴스_클러스터링 {

    class Solution {
        public int solution(String str1, String str2) {

            String s1=str1.toLowerCase();
            String s2=str2.toLowerCase();
            ArrayList<String> list1=new ArrayList<>();
            ArrayList<String> list2=new ArrayList<>();
            ArrayList<String> intersect=new ArrayList<>();
            ArrayList<String> union=new ArrayList<>();

            for(int i=0;i<s1.length()-1;i++){
                if(s1.charAt(i)>='a' && s1.charAt(i)<='z' && s1.charAt(i+1)>='a' && s1.charAt(i+1)<='z'){
                    list1.add(s1.charAt(i)+""+s1.charAt(i+1));
                }
            }
            for(int i=0;i<s2.length()-1;i++){
                if(s2.charAt(i)>='a' && s2.charAt(i)<='z'&& s2.charAt(i+1)>='a' && s2.charAt(i+1)<='z'){
                    list2.add(s2.charAt(i)+""+s2.charAt(i+1));
                }
            }

//         Collections.sort(list1);
//         Collections.sort(list2);

            for(String s:list1){
                if(list2.remove(s)){
                    intersect.add(s);
                }
                union.add(s);
            }

            for(String s:list2){
                union.add(s);
            }

            double jakard=0;

            if(union.size()==0){
                jakard=1;
            } else {
                jakard=(double)intersect.size()/(double)union.size();
            }

            int answer=(int)(jakard*65536);

            return answer;
        }
    }
}
