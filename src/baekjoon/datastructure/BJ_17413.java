package baekjoon.datastructure;

import java.util.*;
import java.io.*;

public class BJ_17413 {

    static Stack<Character> stack=new Stack<>();
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        boolean flag=false;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(ch=='<'){
                reverse_print();
                flag=true;
                sb.append(ch);
            }
            else if(ch=='>'){
                flag=false;
                sb.append(ch);
            }
            else if(flag){
                sb.append(ch);
            }
            else {
                if(ch==' '){
                    reverse_print();
                    sb.append(ch);
                }
                else {
                    stack.push(ch);
                }
            }
        }

        reverse_print();
        System.out.println(sb);

    }

    public static void reverse_print(){

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
    }

}