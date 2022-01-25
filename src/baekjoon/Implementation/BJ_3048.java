package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
서로 다른 집단이라는 것을 나타내기 위해 임의의 클래스를
선언해서 집단을 다르게 표현
 */

public class BJ_3048 {

    static ArrayList<Point> list=new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N1=Integer.parseInt(st.nextToken());
        int N2=Integer.parseInt(st.nextToken());
        String s1=br.readLine();
        String s2=br.readLine();
        int T=Integer.parseInt(br.readLine());

        for(int i=s1.length()-1;i>=0;i--){
            list.add(new Point(s1.charAt(i),1));
        }

        for(int i=0;i<s2.length();i++){
            list.add(new Point(s2.charAt(i),2));
        }

        while (T-->0){
            for(int i=0;i<list.size()-1;i++){
                Point current = list.get(i);
                Point next = list.get(i + 1);
                if(current.num==1 && current.num!=next.num){ // 집단이 다를 경우
                    list.set(i,next);
                    list.set(i+1,current); // swap
                    i++;
                }
            }
        }

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i).ch);
        }

    }

    public static class Point {
        char ch;
        int num;
        public Point(char ch, int num){
            this.ch=ch;
            this.num=num;
        }
    }
}
