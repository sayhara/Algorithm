package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1439 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();
        int zero=0, one=0, result=0;

        if(s.charAt(0)=='0'){
            zero++;
        } else {
            one++;
        }

        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)!=s.charAt(i+1)){
                if(s.charAt(i+1)=='0'){
                    zero++;
                } else {
                    one++;
                }
            }
        }

        result=Math.min(zero,one);
        System.out.println(result);

    }
}
