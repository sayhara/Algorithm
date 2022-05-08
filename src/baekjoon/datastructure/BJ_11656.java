package baekjoon.datastructure;

import java.util.*;
import java.io.*;

public class BJ_11656 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();
        ArrayList<String> list=new ArrayList<>();

        for(int i=0;i<s.length();i++){
            String st=s.substring(i);
            list.add(st);
        }

        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}