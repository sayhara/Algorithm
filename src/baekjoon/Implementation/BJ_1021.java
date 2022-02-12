package baekjoon.Implementation;

import java.io.*;
import java.util.*;

// 양방향 Queue -> LinkedList로 구현

public class BJ_1021 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            int target = list.indexOf(num);
            int half = list.size() / 2;

            if(target<=half){
                while (num!=list.getFirst()){
                    list.add(list.removeFirst());
                    count++;
                }
            }
            else {
                while (num!=list.getFirst()){
                    list.addFirst(list.removeLast());
                    count++;
                }
            }
            list.remove();
        }
        System.out.println(count);
    }
}
