package programmers.level2;

import java.util.*;

public class 수식_최대화 {

    static class Solution {

        static ArrayList<Long> numList=new ArrayList<>();
        static ArrayList<Character> opList=new ArrayList<>();
        static char arr[]={'*','+','-'};
        static boolean visited[]=new boolean[arr.length];
        static char op[]=new char[arr.length];
        static long answer=0;

        public long solution(String expression) {

            String st="";

            for(int i=0;i<expression.length();i++){
                char ch=expression.charAt(i);
                if(ch=='+' || ch=='-' || ch=='*'){
                    opList.add(ch);
                    numList.add(Long.parseLong(st));
                    st="";
                } else {
                    st+=ch;
                }
            }
            numList.add(Long.parseLong(st));

            permutation(op.length,0,op.length);

            return answer;
        }

        public static void permutation(int n, int depth, int r){

            if(depth==r){
                solve();
                return;
            }


            for(int i=0;i<n;i++){
                if(visited[i]==false){
                    visited[i]=true;
                    op[depth]=arr[i];
                    permutation(n,depth+1,r);
                    visited[i]=false;
                }
            }
        }

        public static void solve(){

            ArrayList<Long> num=new ArrayList<>();
            num.addAll(numList);
            ArrayList<Character> oper=new ArrayList<>();
            oper.addAll(opList);

            for(int i=0;i<op.length;i++){
                for(int j=0;j<oper.size();j++){

                    if(op[i]==oper.get(j)){
                        long num1=num.get(j);
                        long num2=num.get(j+1);
                        long result=cal(op[i],num1,num2);

                        num.remove(j+1); // 뒤에있는 값부터 삭제
                        num.remove(j);
                        oper.remove(j);

                        num.add(j,result);
                        j--;
                    }
                }
            }
            answer=Math.max(answer,Math.abs(num.get(0)));

        }

        public static long cal(char ch, long num1, long num2){

            long result=0;

            if(ch=='*'){
                result=num1*num2;
            } else if(ch=='-'){
                result=num1-num2;
            } else if(ch=='+'){
                result=num1+num2;
            }

            return result;
        }
    }
}
