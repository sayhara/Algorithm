package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1002 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int r1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());
            int r2=Integer.parseInt(st.nextToken());

            int dist=(int)(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
            
            // 중점 같고 반지름 같을 때 -> 무한대
            if(x2==x1 && y2==y1 && r1==r2){
                System.out.println(-1);
            }

            // 두 원의 반지름 합보다 중점간 거리가 더 길 때 -> 0
            else if(dist>Math.pow(r2+r1,2)){
                System.out.println(0);
            }

            // 원 내부에 원이 있지만 접하지 않을 때 -> 0
            else if(dist<Math.pow(r2-r1,2)){
                System.out.println(0);
            }

            // 두 원이 내접할 때 -> 한개
            else if(dist==Math.pow(r2-r1,2)) {
                System.out.println(1);
            }

            // 두 원이 외접할 때
            else if(dist==Math.pow(r1+r2,2)){
                System.out.println(1);
            }
            
            // 그 나머지의 경우
            else {
                System.out.println(2);
            }
            
        }
    }
}
