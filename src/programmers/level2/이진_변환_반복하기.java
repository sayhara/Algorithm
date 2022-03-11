package programmers.level2;

public class 이진_변환_반복하기 {

    public static void main(String[] args) {

        Solution solution=new Solution();
        String s="110010101001";
        System.out.println(solution.solution(s));

    }

    static class Solution {
        public int[] solution(String s) {

            int[] answer = new int[2];

            while(true){

                for(int i=0;i<s.length();i++){
                    if(s.charAt(i)=='0'){
                        answer[1]++;
                    }
                }
                s=s.replaceAll("0","");

                int num=s.length();
                String result=Integer.toBinaryString(num);
                answer[0]++;

                if(result.equals("1")){
                    break;
                }

                s=result;

            }

            return answer;
        }
    }
}
