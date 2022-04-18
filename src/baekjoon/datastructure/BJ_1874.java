package baekjoon.datastructure;

import java.util.*;
import java.io.*;

public class BJ_1874 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack=new Stack<>();
        ArrayList<String> list=new ArrayList<>();
        int num=0;

        for(int i=1;i<=N;i++){
            stack.push(i);
            list.add("+");

            while(!stack.isEmpty() && stack.peek()==arr[num]){
                stack.pop();
                list.add("-");
                num++;
            }
        }

        if(stack.isEmpty()){
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
        } else {
            System.out.println("NO");
        }
    }
}