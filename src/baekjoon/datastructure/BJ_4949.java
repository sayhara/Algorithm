package baekjoon.datastructure;

import java.util.*;
import java.io.*;

// 스택 - 괄호검사
// 열린 것은 스택에 넣고, 닫힌 것은 pop() 하는 방식은 맞지만, 만약 (])와 같은 경우라면 올바르게 출력되지 않음
// 따라서 닫힌 것을 pop() 할때는 각각 살펴봐야함

public class BJ_4949 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String s=br.readLine();
            if(s.equals(".")) break;
            if(check(s)){
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static boolean check(String s){

        Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(ch=='(' || ch=='['){
                stack.add(ch);
            }

            else if(ch==')'){

                if(stack.isEmpty() || stack.peek()!='('){
                    return false;
                } else {
                    stack.pop();
                }
            }

            else if(ch==']'){

                if(stack.isEmpty() || stack.peek()!='['){
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if(stack.size()==0){
            return true;
        } else {
            return false;
        }
    }
}