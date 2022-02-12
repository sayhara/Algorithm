package baekjoon.Implementation;

import javafx.beans.binding.StringBinding;

import java.util.*;
import java.io.*;

public class BJ_11866 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        Queue<Integer> q=new LinkedList<>();

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        StringBuilder sb=new StringBuilder();
        sb.append("<");

        for(int i=1;i<=N;i++){
            q.add(i); // 인덱스는 0부터 시작
        }
        
        while (q.size()>1) {

            for (int i = 0; i < K - 1; i++) {
                int num = q.poll();
                q.add(num);
            }

            sb.append(q.poll()).append(",");
        }

        sb.append(q.poll()).append(">");
        System.out.println(sb);

    }
}
