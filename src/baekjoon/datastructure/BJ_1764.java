package baekjoon.datastructure;

import java.io.*;
import java.util.*;

public class BJ_1764 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map=new HashMap<>();
        ArrayList<String> list=new ArrayList<>();

        for(int i=0;i<N;i++){
            String s=br.readLine();
            map.put(s,map.getOrDefault(s,0)+1);
        }

        for(int i=0;i<M;i++){
            String s=br.readLine();
            map.put(s,map.getOrDefault(s,0)+1);
        }

        for(String s:map.keySet()){
            if(map.get(s)>1){
                list.add(s);
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for(String s:list){
            System.out.println(s);
        }
    }
}
