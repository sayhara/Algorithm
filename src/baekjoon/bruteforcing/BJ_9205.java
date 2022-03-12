package baekjoon.bruteforcing;

import java.io.*;
import java.util.*;

public class BJ_9205 {

    static int t,n;
    static String result[];
    static ArrayList<int[]> list;
    static int startR, startC, endR, endC;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        t=Integer.parseInt(br.readLine());
        result=new String[t];

        for(int i=0;i<t;i++){

            n=Integer.parseInt(br.readLine());
            list=new ArrayList<>();

            for(int j=0;j<n+2;j++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                int r=Integer.parseInt(st.nextToken());
                int c=Integer.parseInt(st.nextToken());
                
                if(j==0){ // 처음의 값
                    startR=r;
                    startC=c;
                } else if(j==n+1){ // 마지막 값
                    endR=r;
                    endC=c;
                } else {
                    list.add(new int[]{r,c}); // 제외하고 모두 입력
                }
            }

            if(bfs()){
                result[i]="happy";
            } else {
                result[i]="sad";
            }
        }

        for(int i=0;i<t;i++){
            System.out.println(result[i]);
        }
    }

    public static boolean bfs(){

        Queue<int[]> q=new LinkedList<>();
        boolean visited[]=new boolean[n];
        q.add(new int[]{startR, startC});

        while (!q.isEmpty()){

            int[] now = q.poll();
            int nr=now[0], nc=now[1];

            if(Math.abs(nr-endR)+Math.abs(nc-endC)<=1000){ // 갈 수 있는 상황
                return true;
            }

            for(int i=0;i<n;i++){
                if(!visited[i]){
                    if(Math.abs(nr-list.get(i)[0])+Math.abs(nc-list.get(i)[1])<=1000){
                        q.add(new int[]{list.get(i)[0],list.get(i)[1]});
                        visited[i]=true;
                    }
                }
            }
        }
        return false;
    }
}
