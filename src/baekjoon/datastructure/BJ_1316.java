package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_1316 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int count=N;

        for(int i=0;i<N;i++){
            String s=br.readLine();
            ArrayList<Character> list=new ArrayList<>();
            list.add(s.charAt(0));
            for(int j=1;j<s.length();j++){
                if(!list.contains(s.charAt(j))) list.add(s.charAt(j));
                else if(list.contains(s.charAt(j)) && s.charAt(j-1)!=s.charAt(j)){
                    count--;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}