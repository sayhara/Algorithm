package review;

import java.util.*;

public class 소수_찾기 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        String numbers="011";
        System.out.println(solution.solution(numbers));
    }

    static class Solution {

        static ArrayList<Integer> list=new ArrayList<>();

        public int solution(String numbers) {
            int answer = 0;
            ArrayList<Integer> result=new ArrayList<>();
            char[] ch=new char[numbers.length()];

            for (int i=0;i<numbers.length();i++){
                ch[i]=numbers.charAt(i);
            }

            for(int i=0;i<numbers.length();i++){
                permutation(ch,0,i+1,numbers.length());
            }

            for(int i=0;i<list.size();i++){
                if(!result.contains(list.get(i))){
                    result.add(list.get(i));
                }
            }

            for(int i=0;i<result.size();i++){
                boolean isPrime=false;
                int num=result.get(i);
                for(int j=2;j<num;j++){
                    if(num%j==0){
                        isPrime=true;
                        break;
                    }
                }
                if(!isPrime){ // 소수인 경우
                    answer++;
                }
            }

            return answer;
        }

        // depth : 현재 탐색하는 인덱스, r : 뽑는 개수
        static void permutation(char[] ch, int depth, int r, int length){
            if(depth==r){
                check(ch,r);
                return;
            }
            for(int i=depth;i<length;i++){
                swap(ch,depth,i);
                permutation(ch,depth+1,r,length);
                swap(ch,depth,i);
            }
        }

        static void swap(char[] ch, int depth, int i){
            char temp=ch[depth];
            ch[depth]=ch[i];
            ch[i]=temp;
        }

        static void check(char[] ch, int r){
            String number="";

            for(int i=0;i<r;i++){
                number+=ch[i];
            }

            int value=Integer.parseInt(number);

            if(value>1){
                list.add(value);
            }
        }
    }
}
