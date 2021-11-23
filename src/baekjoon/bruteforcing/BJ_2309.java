package baekjoon.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_2309 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list=new ArrayList<>();
        int sum=0;

        for(int i=0;i<9;i++) {
            list.add(Integer.parseInt(br.readLine()));
            sum+=list.get(i);
        }
        Collections.sort(list);

        loop:
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size();j++){
                if(i==j) continue;
                int a=list.get(i);
                int b=list.get(j);
                if(sum-(a+b)==100){
                    list.remove(Integer.valueOf(a));
                    list.remove(Integer.valueOf(b));
                    break loop;
                }
            }
        }

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
