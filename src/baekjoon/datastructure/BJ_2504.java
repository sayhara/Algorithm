package baekjoon.datastructure;

import java.util.*;
import java.io.*;

public class BJ_2504 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack=new Stack<>();
        String s=br.readLine();
        int sum=0, value=1;

        for(int i=0;i<s.length();i++){

            char ch=s.charAt(i);

            switch (ch){
                case '(':
                    stack.add(ch);
                    value*=2;
                    break;
                case '[':
                    stack.add(ch);
                    value*=3;
                    break;
                case ')':
                    if(stack.isEmpty() || stack.peek()!='('){
                        System.out.println(0);
                        return;
                    } else if(s.charAt(i-1)=='('){ // stack.peek()로 했을 때 [()]의 경우 => 6+2
                        sum+=value;
                    }
                    stack.pop();
                    value/=2;
                    break;
                case ']':
                    if(stack.isEmpty() || stack.peek()!='['){
                        System.out.println(0);
                        return;
                    } else if(s.charAt(i-1)=='['){
                        sum+=value;
                    }
                    stack.pop();
                    value/=3;
                    break;
            }
        }

        if(stack.size()==0){
            System.out.println(sum);
        } else {
            System.out.println(0);
        }
    }
}