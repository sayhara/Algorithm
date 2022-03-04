package baekjoon.Implementation;

import java.io.*;
import java.util.ArrayList;

public class BJ_11729 {

    static ArrayList<int[]> list=new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        hanoi(N,1,2,3);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i)[0]+" "+list.get(i)[1]);
        }

    }

    public static void hanoi(int n, int from, int tmp, int to){

        if(n==1){
            list.add(new int[]{from,to});
            return;
        }
        else {
            hanoi(n-1,from,to,tmp); // 가장 큰 원반을 목적지(to)로 옮기기 위해서는 n-1개의 원반을 일단 임시의 장소(tmp)에 옮겨야 함
            list.add(new int[]{from,to}); // 맨 아래 원반 이동
            hanoi(n-1,tmp,from,to); // 다른 곳에 있었던 원반을 다시 목적지로 옮기기
        }
    }
}
