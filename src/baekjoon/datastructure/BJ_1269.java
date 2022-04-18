package baekjoon.datastructure;

import java.util.*;
import java.io.*;

public class BJ_1269 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<A;i++){
            set1.add(Integer.parseInt(st.nextToken()));
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<B;i++){
            set2.add(Integer.parseInt(st.nextToken()));
        }

        int countA=0,countB=0;

        for(Integer i:set1){
            if(set2.contains(i)){
                countA++;
            }
        }

        for(Integer i:set2){
            if(set1.contains(i)){
                countB++;
            }
        }

        System.out.println(set1.size()-countA+set2.size()-countB);

    }
}