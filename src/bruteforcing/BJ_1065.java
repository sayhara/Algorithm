package bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1065 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int num=100;
        int count=0;

        if(N<100){
            System.out.println(N);
        } else {

            while(true) {

                int hun = num / 100;
                int ten = num / 10 % 10;
                int one = num % 10;

                if((hun-ten)==(ten-one)){
                    count++;
                }

                if(N==num){
                    System.out.println(99+count);
                    break;
                }

                num++;

            }
        }
    }
}
