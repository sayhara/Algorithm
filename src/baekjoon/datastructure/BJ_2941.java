package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ_2941 {

    static HashSet<String> set=new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();

        s=s.replaceAll("c="," ");
        s=s.replaceAll("c-"," ");
        s=s.replaceAll("dz="," ");
        s=s.replaceAll("d-"," ");
        s=s.replaceAll("lj"," ");
        s=s.replaceAll("nj"," ");
        s=s.replaceAll("s="," ");
        s=s.replaceAll("z="," ");
        System.out.println(s.length());

    }
}