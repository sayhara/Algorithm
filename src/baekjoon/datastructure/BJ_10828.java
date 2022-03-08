package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_10828 {

    // 스택

    public static void main(String[] args) throws IOException {

        Scanner sc=new Scanner(System.in);

        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String s = sc.next();

            if (s.equals("push")) {
                int num = sc.nextInt();
                stack.add(num);
            } else if (s.equals("pop")) {
                System.out.println(stack.isEmpty()?-1:stack.pop());
            } else if (s.equals("size")) {
                System.out.println(stack.size());
            } else if (s.equals("empty")) {
                System.out.println(stack.isEmpty()?1:0);
            } else if (s.equals("top")) {
                System.out.println(stack.isEmpty()?-1:stack.peek());
            }
        }
    }
}
