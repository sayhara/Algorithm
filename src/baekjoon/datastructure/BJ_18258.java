package baekjoon.datastructure;

import java.io.*;
import java.util.*;

public class BJ_18258 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine()); // 명령어 수
        LinkedList<Integer> q=new LinkedList<>(); // 양방향 큐 -> LinkedList
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            String s=st.nextToken();
            if(s.equals("push")){
                int num=Integer.parseInt(st.nextToken());
                q.add(num);
            } else if(s.equals("pop")){
                sb.append(q.isEmpty()?-1:q.poll());
                sb.append("\n");
            } else if(s.equals("size")){
                sb.append(q.size());
                sb.append("\n");
            } else if(s.equals("empty")){
                sb.append(q.isEmpty()?1:0);
                sb.append("\n");
            } else if(s.equals("front")){
                sb.append(q.isEmpty()?-1:q.getFirst());
                sb.append("\n");
            } else if(s.equals("back")){
                sb.append(q.isEmpty()?-1:q.getLast());
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
