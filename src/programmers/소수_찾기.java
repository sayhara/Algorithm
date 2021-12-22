package programmers;

import java.util.ArrayList;

public class 소수_찾기 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        String numbers="17";
        System.out.println(solution.solution(numbers));
    }

    static class Solution {

        static ArrayList<Integer> list=new ArrayList<>();

        public int solution(String numbers) {

            char value[]=new char[numbers.length()];
            ArrayList<Integer> result=new ArrayList<>();
            int count=0;

            for(int i=0;i<numbers.length();i++){
                value[i] = numbers.charAt(i);
            }

            for(int i=0;i<value.length;i++) {
                calculation(0,i+1, value.length, value);
            }

            for(int i=0;i<list.size();i++){     // 중복 제거 과정
                if(!result.contains(list.get(i))){
                    result.add(list.get(i));
                }
            }

            for(int i=0;i<result.size();i++) {    // 소수 판별 과정
                int num=result.get(i);
                boolean isPrime=false;
                for(int j=2;j<num;j++) {
                    if(num%j==0) {
                        isPrime=true;
                        break;
                    }
                }
                if(!isPrime) {
                    count++;
                }
            }

            int answer = count;
            return answer;
        }

        // start :  시작점, r : 뽑는 개수 (조합)
        public void calculation(int depth, int r, int length, char value[]) {

            if(depth==r){
                div(r, value);
                return;
            }

            for(int i=depth;i<length;i++){
                swap(depth, i, value);
                calculation(depth+1, r, length, value);
                swap(depth, i, value);
            }
        }

        public void swap(int depth, int i, char[] value) {
            char temp=value[depth];
            value[depth]=value[i];
            value[i]=temp;
        }

        public void div(int r, char value[]) {

            String number = "";

            for (int i = 0; i < r; i++) {
                number += value[i];
            }

            int num = Integer.parseInt(number);

            if(num>1) {
                list.add(num);
            }
        }
    }
}
