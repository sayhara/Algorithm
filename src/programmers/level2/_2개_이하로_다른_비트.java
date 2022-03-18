package programmers.level2;

public class _2개_이하로_다른_비트 {

    class Solution {
        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];

            for(int i=0;i<numbers.length;i++){
                if(numbers[i]%2==0){
                    answer[i]=numbers[i]+1;
                }
                else {

                    String s=Long.toBinaryString(numbers[i]);
                    int zero=s.lastIndexOf("0");
                    if(zero!=-1){ // 1로만 이루어진 경우가 아닐 때 101111 -> 110111
                        s=s.substring(0,zero)+"10"+s.substring(zero+2,s.length());
                        answer[i]=Long.parseLong(s,2);
                    } else { // 1로만 이루어진 경우 111111 -> 1011111
                        s="10"+s.substring(1,s.length());
                        answer[i]=Long.parseLong(s,2);
                    }
                }
            }

            return answer;
        }
    }
}
