package baekjoon.datastructure;

import java.util.*;
import java.io.*;

public class BJ_9012 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        String result[]=new String[N];

        for(int i=0;i<N;i++) {
            String s = br.readLine();
            result[i]=check(s);
        }

        for(int i=0;i<N;i++){
            System.out.println(result[i]);
        }
    }

    public static String check(String s){

        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.add('(');
            } else {
                if(stack.isEmpty()){
                    return "NO";
                } else {
                    stack.pop();
                }
            }
        }
        if(stack.size()==0){
            return "YES";
        } else {
            return "NO";
        }
    }
}