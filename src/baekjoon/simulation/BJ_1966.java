package baekjoon.simulation;

import java.util.*;
import java.io.*;

public class BJ_1966 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken()); // 문서의 개수
            int M=Integer.parseInt(st.nextToken()); // 정수
            int cnt=0;

            Queue<int[]> queue=new LinkedList<>();
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                queue.add(new int[]{j,Integer.parseInt(st.nextToken())});
            }

            while(true){
                int now[]=queue.poll();
                boolean flag=true;

                for(int[] s:queue){
                    if(s[1]>now[1]){
                        flag=false;
                        break;
                    }
                }

                if(flag){
                    cnt++;
                    if(now[0]==M) break;
                } else {
                    queue.add(now);
                }
            }
            System.out.println(cnt);
        }
    }
}
