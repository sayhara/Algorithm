package baekjoon.datastructure;

import java.util.*;
import java.io.*;

public class BJ_4358 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map=new HashMap<>();
        int count=0;

        while(true){
            String s=br.readLine();
            if(s==null || s.equals("")) break;
            map.put(s,map.getOrDefault(s,0)+1);
            count++;
        }

        ArrayList<String> list=new ArrayList<>(map.keySet()); // 문자열 오름차순
        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            double value= (double)(map.get(list.get(i))*100)/count;
            String res=String.format("%.4f",value);
            System.out.println(list.get(i)+" "+res);
        }
    }
}