package programmers.level1;

/*
https://tildacoderecorder.tistory.com/93
 */

public class 신규_아이디_추천 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        String new_id="...!@BaT#*..y.abcdefghijklm";
        System.out.println(solution.solution(new_id));

    }

    static class Solution {
        public String solution(String new_id) {
            String answer = new_id.toLowerCase(); // 대문자 -> 소문자

            answer=answer.replaceAll("[^a-z0-9-_.]",""); // 해당 문자열 제외 제거
            answer=answer.replaceAll("[.]{2,}","."); // 2개 이상 사용된 문자 제거
            answer=answer.replaceAll("^[.]|[.]$",""); // 처음이나 끝에 오면 제거

            if(answer.length()==0)
                answer+="a";

            if(answer.length()>=16){
                answer=answer.substring(0,15);
                answer=answer.replaceAll("[.]$",""); // 마지막에 마침표 제거
            }

            if(answer.length()<=2){
                while (answer.length()!=3){
                    answer+=answer.charAt(answer.length()-1);
                }
            }

            return answer;
        }
    }
}
