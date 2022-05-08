package baekjoon.datastructure;

import java.util.*;
import java.io.*;

public class BJ_5430 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        while(T-->0){

            String command=br.readLine(); // 명령어
            int n=Integer.parseInt(br.readLine()); // 배열의 수
            String s=br.readLine(); // 배열
            s= s.substring(1,s.length()-1);
            String[] arr=s.split(",");
            Deque<String> deque=new LinkedList<>();

            for(int i=0;i<arr.length;i++){
                if(!arr[i].equals(""))
                    deque.add(arr[i]);
            }
            System.out.println(solve(command,deque));
        }
    }

    private static String solve(String command, Deque<String> deque) {

        boolean isReverse=false;

        for(int i = 0; i< command.length(); i++){
            if(command.charAt(i)=='R'){
                isReverse=!isReverse;
            }
            else {
                if(deque.size()==0){
                    return "error";
                }
                if(isReverse){
                    deque.removeLast(); // 역방향
                }
                if(!isReverse){
                    deque.removeFirst(); // 정방향
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        sb.append("[");

        if(isReverse){
            while(!deque.isEmpty()){
                sb.append(deque.pollLast());
                if(deque.size()!=0) sb.append(",");
            }
        }

        if(!isReverse){
            while(!deque.isEmpty()){
                sb.append(deque.pollFirst());
                if(deque.size()!=0) sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}