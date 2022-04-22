package baekjoon.datastructure;

import java.util.*;
import java.io.*;

public class BJ_1927 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<N;i++){
            int num=Integer.parseInt(br.readLine());
            if(num==0){
                if(pq.isEmpty()){
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(num);
            }
        }
    }
}