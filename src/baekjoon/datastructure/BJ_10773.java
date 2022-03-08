package baekjoon.datastructure;

import java.io.*;
import java.util.*;

public class BJ_10773 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int K=Integer.parseInt(br.readLine());
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<K;i++){
            int num=Integer.parseInt(br.readLine());
            if(num==0){
                stack.pop();
            }
            else {
                stack.add(num);
            }
        }

        int sum=0;

        while (!stack.isEmpty()){
            sum+=stack.pop();
        }

        System.out.println(sum);
    }
}
