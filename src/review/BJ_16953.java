package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16953 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());
        int count=1;

        while (true){

            if(A==B){
                System.out.println(count);
                return;
            }

            if(A>B){
                System.out.println(-1);
                return;
            }

            if(B%10==1){
                B=B/10;
            } else if(B%2==0){
                B=B/2;
            } else {
                System.out.println(-1);
                return;
            }
            count++;

        }
    }
}
