package baekjoon.datastructure;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class BJ_2870 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<BigInteger> list=new ArrayList<>();

        int N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String s[]=br.readLine().split("[^0-9]");
            for(int j=0;j<s.length;j++){
                if(!s[j].equals("")) {
                    list.add(new BigInteger(s[j]));
                }
            }
        }

        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}