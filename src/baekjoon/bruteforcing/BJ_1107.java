package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1107 {

    static int N,M;
    static boolean[] broken;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine()); // 이동하려는 채널
        M=Integer.parseInt(br.readLine()); // 고장난 버튼 개수
        broken=new boolean[10]; // 0~9번

        if(M>0) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                 int num = Integer.parseInt(st.nextToken());
                 broken[num]=true;
            }
        }

        int min=Math.abs(N-100);

        for(int i=0;i<1000000;i++){ // 모든 채널에 대한 탐색
            String st = String.valueOf(i);
            boolean isBroken=false;
            int button=st.length();

            for(int j=0;j<button;j++){
                if(broken[st.charAt(j)-'0']){
                    isBroken=true;
                    break; // 더이상 탐색 x
                }
            }
            if(!isBroken){
                int value=Math.abs(N-i)+button;
                min=Math.min(min,value);
            }
        }

        System.out.println(min);

    }
}
