package baekjoon.datastructure;

import java.util.*;
import java.io.*;

public class BJ_1755 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map=new HashMap<>();

        for(int i=M;i<=N;i++){
            String s=Integer.toString(i);
            String res="";
            for(int j=0;j<s.length();j++){
                res+=change(s.charAt(j)+"");
            }
            map.put(res,i);
        }

        ArrayList<String> list=new ArrayList<>(map.keySet());
        Collections.sort(list);

        int count=0;
        for(int i=0;i<list.size();i++){
            String s=list.get(i);
            count++;
            System.out.print(map.get(s)+" ");
            if(count==10){
                System.out.println();
                count=0;
            }
        }
    }

    public static String change(String s) {

        String[][] st = {{"0", "zero"}, {"1", "one"}, {"2", "two"}, {"3", "three"}, {"4", "four"},
                {"5", "five"}, {"6", "six"}, {"7", "seven"}, {"8", "eight"}, {"9", "nine"}};

        String result = "";

        for (int i = 0; i < st.length; i++) {
            if (st[i][0].equals(s)) {
                result = st[i][1];
                break;
            }
        }

        return result;
    }
}