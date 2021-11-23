package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
처음에 ArrayList를 이용하여 풀이를 했다가 시간초과가 발생하였다.
이에 시간복잡도를 더 적게 가지는 우선순위 큐를 이용하여 구현하였다.
우선순위 큐를 이용하여 값을 입력하면 낮은 순으로 정렬이 되어진다.
이에 따라, 매번 정렬하지 않고 새롭게 값을 삽입할 수 있어 시간복잡도를 크게
줄일 수 있었다.
 */

public class BJ_1715 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> arr=new PriorityQueue<>(); // 우선순위가 낮은 순으로 정렬
        int sum=0;

        for(int i=0;i<N;i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        while(arr.size()>1) {

            int a=arr.poll();
            int b=arr.poll();
            int c=a+b;

            sum += c;
            arr.add(c);
        }

        System.out.println(sum);
    }
}
